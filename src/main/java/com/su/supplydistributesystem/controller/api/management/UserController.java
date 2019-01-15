package com.su.supplydistributesystem.controller.api.management;

import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.rest.view.SuccessView;
import com.su.supplydistributesystem.domain.User;
import com.su.supplydistributesystem.service.UserService;
import com.su.supplydistributesystem.request.UserCreateForm;
import com.su.supplydistributesystem.request.UserUpdateForm;
import com.su.supplydistributesystem.request.UserListForm;
import com.su.supplydistributesystem.response.UserListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Objects;

import static com.su.supplydistributesystem.constants.CommonConstants.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public UserListView list(@Valid @RequestBody UserListForm form){
        return new UserListView(userService.selectList(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL,method = RequestMethod.GET)
    public User detail(@PathVariable Integer id){
        return userService.getById(id);
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    public SuccessView create(@Valid @RequestBody UserCreateForm form){
        User user = new User();
        BeanUtils.copyProperties(form,user);
        userService.create(user);
        return new SuccessView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    public SuccessView update(@Valid @RequestBody UserUpdateForm form){
        User user = userService.getById(form.getId());
        if(Objects.isNull(user)){
            throw new ResourceNotFoundException("user not exists");
        }
        BeanUtils.copyProperties(form,user);
        userService.update(user);
        return new SuccessView();
    }
}
