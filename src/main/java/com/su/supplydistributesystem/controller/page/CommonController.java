package com.su.supplydistributesystem.controller.page;

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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

import static com.su.supplydistributesystem.constants.CommonConstants.*;

@Controller("commonManagementController")
@RequestMapping(value = "/management")
public class CommonController {
    @Autowired
    private UserService userService;

    @Autowired
    private SessionContext sessionContext;

    @RequestMapping(value = LOGIN, method = RequestMethod.GET)
    public String login(@RequestParam(required = false) String redirectUrl,ModelMap modelMap) {
        modelMap.put("redirectUrl", StringUtils.hasText(redirectUrl) ? "/management/index" : redirectUrl);
        return "management/login";
    }

    @RequestMapping(value = INDEX, method = RequestMethod.GET)
    @UserLoginRequired
    public String index(ModelMap modelMap) {
        modelMap.put("user",sessionContext.getUser());
        return "management/index";
    }
}
