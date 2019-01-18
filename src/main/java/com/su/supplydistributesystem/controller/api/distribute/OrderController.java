package com.su.supplydistributesystem.controller.api.distribute;

import com.su.supplydistributesystem.context.SessionContext;
import com.su.supplydistributesystem.interceptor.DistributorLoginRequired;
import com.su.supplydistributesystem.request.OrderDistributeListForm;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.su.supplydistributesystem.constants.CommonConstants.LIST;

@RestController("distributeOrderManagementApiController")
@RequestMapping(value = "/dApi/order")
@DistributorLoginRequired
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private SessionContext sessionContext;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public OrderDetailParamsView list(@Valid @RequestBody OrderDistributeListForm form){
        Map<String,Object> query = form.getQueryMap();
        query.put("distributorId",sessionContext.getDistributor().getId());
        return new OrderDetailParamsView(orderService.selectOrderDetailParamsViewList(query),orderService.selectCount(query));
    }

}
