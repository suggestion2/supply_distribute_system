package com.su.supplydistributesystem.controller.api.distribute;


import com.su.supplydistributesystem.context.SessionContext;
import com.su.supplydistributesystem.domain.Distributor;
import com.su.supplydistributesystem.interceptor.DistributorLoginRequired;
import com.su.supplydistributesystem.request.DistributorLoginForm;
import com.su.supplydistributesystem.request.DistributorUpdatePasswordForm;
import com.su.supplydistributesystem.request.LoginForm;
import com.su.supplydistributesystem.request.ResetPasswordForm;
import com.su.supplydistributesystem.service.DistributorService;
import com.sug.core.platform.crypto.MD5;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.rest.view.ResponseView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.Objects;

import static com.su.supplydistributesystem.constants.CommonConstants.*;

@RestController("distributeSupplierApiController")
@RequestMapping(value = "/dApi/distributor")
public class DistributorController {
    private static final Logger logger = LoggerFactory.getLogger(DistributorController.class);

    @Autowired
    private DistributorService distributorService;

    @Autowired
    private SessionContext sessionContext;

    @RequestMapping(value = LOGIN, method = RequestMethod.POST)
    public ResponseView login(@Valid @RequestBody DistributorLoginForm form) {
        Distributor distributor = distributorService.getByAccount(form.getAccount());
        if(Objects.isNull(distributor) ||
                !MD5.encrypt(form.getPassword() + MD5_SALT).equalsIgnoreCase(distributor.getPassword())){
            throw new ResourceNotFoundException("distributor not found");
        }
        sessionContext.setDistributor(distributor);
        return new ResponseView();
    }

    @RequestMapping(value = CURRENT, method = RequestMethod.GET)
    @DistributorLoginRequired
    public Distributor current() {
        Distributor distributor = sessionContext.getDistributor();
        return distributor;
    }

    @RequestMapping(value = "/password", method = RequestMethod.PUT)
    @DistributorLoginRequired
    public ResponseView resetPassword(@Valid @RequestBody DistributorUpdatePasswordForm form) {
        if(!Objects.equals(form.getNewPassword(),form.getRepeatPassword())){
            throw new InvalidRequestException("invalidPassword","Inconsistent password entered twice");
        }
        Distributor distributor = sessionContext.getDistributor();
        //判断输入的原密码是否正确
        if(!MD5.encrypt(form.getOriginPassword() + MD5_SALT).equalsIgnoreCase(distributor.getPassword())){
            throw new InvalidRequestException("invalidPassword","invalid origin password");
        }
        distributor.setPassword(MD5.encrypt(form.getNewPassword() + MD5_SALT));
        distributorService.updatePassword(distributor);
        return new ResponseView();
    }

    @RequestMapping(value = LOGOUT, method = RequestMethod.GET)
    public ResponseView logout() {
        sessionContext.logout();
        return new ResponseView();
    }
}
