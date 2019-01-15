package com.su.supplydistributesystem.controller.api.management;

import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.rest.view.SuccessView;
import com.su.supplydistributesystem.domain.OrderItem;
import com.su.supplydistributesystem.service.OrderItemService;
import com.su.supplydistributesystem.request.OrderItemCreateForm;
import com.su.supplydistributesystem.request.OrderItemUpdateForm;
import com.su.supplydistributesystem.request.OrderItemListForm;
import com.su.supplydistributesystem.response.OrderItemListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Objects;

import static com.su.supplydistributesystem.constants.CommonConstants.*;

@RestController
@RequestMapping(value = "/orderItem")
public class OrderItemController {

    private static final Logger logger = LoggerFactory.getLogger(OrderItemController.class);

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public OrderItemListView list(@Valid @RequestBody OrderItemListForm form){
        return new OrderItemListView(orderItemService.selectList(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL,method = RequestMethod.GET)
    public OrderItem detail(@PathVariable Integer id){
        return orderItemService.getById(id);
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    public SuccessView create(@Valid @RequestBody OrderItemCreateForm form){
        OrderItem orderItem = new OrderItem();
        BeanUtils.copyProperties(form,orderItem);
        orderItemService.create(orderItem);
        return new SuccessView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    public SuccessView update(@Valid @RequestBody OrderItemUpdateForm form){
        OrderItem orderItem = orderItemService.getById(form.getId());
        if(Objects.isNull(orderItem)){
            throw new ResourceNotFoundException("orderItem not exists");
        }
        BeanUtils.copyProperties(form,orderItem);
        orderItemService.update(orderItem);
        return new SuccessView();
    }
}
