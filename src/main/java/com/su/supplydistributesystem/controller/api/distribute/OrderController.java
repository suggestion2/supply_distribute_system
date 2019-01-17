package com.su.supplydistributesystem.controller.api.distribute;

import com.su.supplydistributesystem.request.OrderListForm;
import com.su.supplydistributesystem.response.OrderListView;
import com.su.supplydistributesystem.service.OrderDetailParams;
import com.su.supplydistributesystem.service.OrderItemService;
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

@RestController("orderManagementApiController")
@RequestMapping(value = "/dApi/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;



//    @RequestMapping(value = LIST,method = RequestMethod.POST)
//    public OrderListView list(@Valid @RequestBody OrderListForm form){
//        List<OrderDetailParams> list = orderService.selectOrderDetailParamsViewList(form.getQueryMap());
//
////        return new OrderListView(orderService.selectOrderDetailParamsViewList(form.getQueryMap()),orderService.selectCount(form.getQueryMap()));
//    }

}
