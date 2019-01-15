package com.su.supplydistributesystem.controller.api.management;

import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.rest.view.SuccessView;
import com.su.supplydistributesystem.domain.Order;
import com.su.supplydistributesystem.service.OrderService;
import com.su.supplydistributesystem.request.OrderCreateForm;
import com.su.supplydistributesystem.request.OrderUpdateForm;
import com.su.supplydistributesystem.request.OrderListForm;
import com.su.supplydistributesystem.response.OrderListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Objects;

import static com.su.supplydistributesystem.constants.CommonConstants.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public OrderListView list(@Valid @RequestBody OrderListForm form){
        return new OrderListView(orderService.selectList(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL,method = RequestMethod.GET)
    public Order detail(@PathVariable Integer id){
        return orderService.getById(id);
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    public SuccessView create(@Valid @RequestBody OrderCreateForm form){
        Order order = new Order();
        BeanUtils.copyProperties(form,order);
        orderService.create(order);
        return new SuccessView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    public SuccessView update(@Valid @RequestBody OrderUpdateForm form){
        Order order = orderService.getById(form.getId());
        if(Objects.isNull(order)){
            throw new ResourceNotFoundException("order not exists");
        }
        BeanUtils.copyProperties(form,order);
        orderService.update(order);
        return new SuccessView();
    }
}
