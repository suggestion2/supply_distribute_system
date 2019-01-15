package com.su.supplydistributesystem.controller.api.management;

import com.su.supplydistributesystem.context.SessionContext;
import com.su.supplydistributesystem.domain.User;
import com.su.supplydistributesystem.interceptor.UserLoginRequired;
import com.su.supplydistributesystem.request.LoginForm;
import com.su.supplydistributesystem.request.ResetPasswordForm;
import com.su.supplydistributesystem.response.UserView;
import com.su.supplydistributesystem.service.UserService;
import com.sug.core.platform.crypto.MD5;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.rest.view.ResponseView;
import com.sug.core.rest.view.SuccessView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

import static com.su.supplydistributesystem.constants.CommonConstants.*;

@RestController("commonManagementApiController")
@RequestMapping(value = "/mApi")
public class CommonController {
    @Autowired
    private UserService userService;

    @Autowired
    private SessionContext sessionContext;

    @RequestMapping(value = LOGIN, method = RequestMethod.POST)
    public ResponseView login(@Valid @RequestBody LoginForm form) {
        User user = userService.getByName(form.getName());
        if(Objects.isNull(user) ||
                !MD5.encrypt(form.getPassword() + MD5_SALT).equalsIgnoreCase(user.getPassword())){
            throw new ResourceNotFoundException("user not found");
        }
        sessionContext.setUser(user);
        return new ResponseView();
    }

    @RequestMapping(value = "/password", method = RequestMethod.PUT)
    @UserLoginRequired
    public ResponseView resetPassword(@Valid @RequestBody ResetPasswordForm form) {
        User user = sessionContext.getUser();
        if(!MD5.encrypt(form.getOriginPassword() + MD5_SALT).equalsIgnoreCase(user.getPassword())){
            throw new InvalidRequestException("invalidPassword","invalid origin password");
        }
        user.setPassword(MD5.encrypt(form.getNewPassword() + MD5_SALT));
        userService.update(user);
        return new ResponseView();
    }

    @RequestMapping(value = CURRENT, method = RequestMethod.GET)
    @UserLoginRequired
    public UserView current() {
        UserView view = new UserView();
        BeanUtils.copyProperties(sessionContext.getUser(),view);
        return view;
    }

    @RequestMapping(value = LOGOUT, method = RequestMethod.GET)
    public ResponseView logout() {
        sessionContext.logout();
        return new ResponseView();
    }
}
