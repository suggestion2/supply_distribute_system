package com.su.supplydistributesystem.controller.page;

import com.su.supplydistributesystem.interceptor.UserLoginRequired;
import com.su.supplydistributesystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.su.supplydistributesystem.constants.CommonConstants.*;

@Controller("orderManagementController")
@RequestMapping(value = "/management/order")
@UserLoginRequired
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private DistributorService distributorService;

    @RequestMapping(value = LIST, method = RequestMethod.GET)
    public String list() {
        return "management/orderList";
    }

    @RequestMapping(value = CREATE, method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        modelMap.put("goods",goodsService.getAllEnabledList());
        modelMap.put("distributor",distributorService.getAllEnabledList());
        return "management/orderCreate";
    }

    @RequestMapping(value = DETAIL_ID, method = RequestMethod.GET)
    public String detail(@PathVariable Integer id,ModelMap modelMap) {
        modelMap.put("order",orderService.getDetail(id));
        modelMap.put("goods",goodsService.getAllEnabledList());
        modelMap.put("distributor",distributorService.getAllEnabledList());
        return "management/orderDetail";
    }
}
