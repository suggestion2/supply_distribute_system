package com.su.supplydistributesystem.controller.page;


import com.su.supplydistributesystem.interceptor.UserLoginRequired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.su.supplydistributesystem.constants.CommonConstants.LIST;

@Controller("distributorManagementController")
@RequestMapping(value = "/management/distributor")
@UserLoginRequired
public class DistributorController {

    @RequestMapping(value = LIST, method = RequestMethod.GET)
    public String list(){
        return "management/distributorList";
    }

}
