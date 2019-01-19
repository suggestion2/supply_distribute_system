package com.su.supplydistributesystem.controller.page;

import com.su.supplydistributesystem.interceptor.UserLoginRequired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.su.supplydistributesystem.constants.CommonConstants.LIST;

@Controller("supplierManagementController")
@RequestMapping(value = "/management/supplier")
@UserLoginRequired
public class SupplierController {

    @RequestMapping(value = LIST, method = RequestMethod.GET)
    public String list(){
        return "management/supplier/supplierList";
    }
}
