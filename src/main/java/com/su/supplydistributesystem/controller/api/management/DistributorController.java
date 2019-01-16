package com.su.supplydistributesystem.controller.api.management;

import com.su.supplydistributesystem.context.SessionContext;
import com.su.supplydistributesystem.domain.GoodsCategory;
import com.su.supplydistributesystem.domain.Supplier;
import com.su.supplydistributesystem.domain.User;
import com.su.supplydistributesystem.interceptor.UserLoginRequired;
import com.su.supplydistributesystem.request.*;
import com.sug.core.platform.crypto.MD5;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.rest.view.ResponseView;
import com.sug.core.rest.view.SuccessView;
import com.su.supplydistributesystem.domain.Distributor;
import com.su.supplydistributesystem.service.DistributorService;
import com.su.supplydistributesystem.response.DistributorListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.su.supplydistributesystem.constants.DistributorConstants.*;
import static com.su.supplydistributesystem.constants.CommonConstants.*;

@RestController("distributorApiController")
@RequestMapping(value = "/mApi/distributor")
@UserLoginRequired
public class DistributorController {

    private static final Logger logger = LoggerFactory.getLogger(DistributorController.class);

    @Autowired
    private DistributorService distributorService;

    @Autowired
    private SessionContext sessionContext;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public DistributorListView list(@Valid @RequestBody DistributorListForm form){
        return new DistributorListView(distributorService.selectList(form.getQueryMap()),distributorService.selectCount(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL,method = RequestMethod.GET)
    public Distributor detail(@PathVariable Integer id){
        return distributorService.getById(id);
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    public ResponseView create(@Valid @RequestBody DistributorCreateForm form){
        Map<String,Object> query = new HashMap<>();
        query.put("account",form.getAccount());
        query.put("name",form.getName());
        query.put("phone",form.getPhone());
        List<Distributor> disList = distributorService.getByNameOrAccount(query);
        //判断添加的用户名/账号/手机是否存在
        if(disList.size()>0){
            throw new InvalidRequestException("multipleName","supplier or account or phone exists");
        }
        Distributor distributor = new Distributor();
        //设置默认123456密码
        BeanUtils.copyProperties(form,distributor);
        distributor.setPassword(MD5.encrypt("123456" + MD5_SALT));
        distributor.setCreateBy(sessionContext.getUser().getId());
        distributor.setUpdateBy(sessionContext.getUser().getId());
        distributorService.create(distributor);
        return new ResponseView();
    }

    @RequestMapping(value = "/resetStatus", method = RequestMethod.PUT)
    public ResponseView resetStatus(@Valid @RequestBody GoodsCategoryStatusForm form) {
        Distributor distributor = distributorService.getById(form.getId());
        if (Objects.isNull(distributor)) {
            throw new ResourceNotFoundException("distributor not exists");
        }
        if (!form.getStatus().equals(ENABLE) && !form.getStatus().equals(DISABLE)){
            throw new InvalidRequestException("invalidStatus","invalid status");
        }
        if (!distributor.getStatus().equals(form.getStatus())){
            distributor.setStatus(form.getStatus());
            distributor.setUpdateBy(sessionContext.getUser().getId());
            distributorService.update(distributor);
        }
        return new ResponseView();
    }

    //重置密码
    @RequestMapping(value = "/password", method = RequestMethod.PUT)
    @UserLoginRequired
    public ResponseView resetPassword(@Valid @RequestBody ResetDistributorPasswordForm form) {
        Distributor distributor = distributorService.getById(form.getId());
        if(Objects.isNull(distributor)){
            throw new ResourceNotFoundException("distributor not exists");
        }
        distributor.setPassword(MD5.encrypt("123456" + MD5_SALT));
        distributorService.update(distributor);
        return new ResponseView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    public SuccessView update(@Valid @RequestBody DistributorUpdateForm form){
        Distributor distributor = distributorService.getById(form.getId());
        if(Objects.isNull(distributor)){
            throw new ResourceNotFoundException("distributor not exists");
        }
        //TODO:判断order里面是否有这个分销商账号
        Map<String,Object> query = new HashMap<>();
        query.put("account",form.getAccount());
        query.put("name",form.getName());
        query.put("phone",form.getPhone());
        List<Distributor> disList = distributorService.getByNameOrAccount(query);
        //判断修改的用户名/账号/手机是否存在
        if(disList.size()>0){
            throw new InvalidRequestException("multipleName","supplier or account or phone exists");
        }
        BeanUtils.copyProperties(form,distributor);
        distributorService.update(distributor);
        return new SuccessView();
    }


    @RequestMapping(value = DELETE_BY_ID, method = RequestMethod.DELETE)
    public ResponseView deleteById(@PathVariable Integer id) {
        //TODO:检查order是否有此账号
        distributorService.deleteById(id);
        return new ResponseView();
    }

}
