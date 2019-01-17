package com.su.supplydistributesystem.controller.api.distribute;

import com.su.supplydistributesystem.interceptor.DistributorLoginRequired;
import com.su.supplydistributesystem.request.OrderListForm;
import com.su.supplydistributesystem.response.OrderDetailParamsView;
import com.su.supplydistributesystem.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.List;

import static com.su.supplydistributesystem.constants.CommonConstants.LIST;

@RestController("distributeOrderManagementApiController")
@RequestMapping(value = "/dApi/order")
@DistributorLoginRequired
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public OrderDetailParamsView list(@Valid @RequestBody OrderListForm form){
        return new OrderDetailParamsView(orderService.selectOrderDetailParamsViewList(form.getQueryMap()),orderService.selectCount(form.getQueryMap()));
    }

}
