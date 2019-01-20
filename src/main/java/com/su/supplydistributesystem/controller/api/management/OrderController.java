package com.su.supplydistributesystem.controller.api.management;

import com.su.supplydistributesystem.context.SessionContext;
import com.su.supplydistributesystem.domain.Distributor;
import com.su.supplydistributesystem.domain.OrderItem;
import com.su.supplydistributesystem.domain.User;
import com.su.supplydistributesystem.interceptor.UserLoginRequired;
import com.su.supplydistributesystem.mapper.OrderItemUpdateParams;
import com.su.supplydistributesystem.request.*;
import com.su.supplydistributesystem.response.OrderDetailView;
import com.su.supplydistributesystem.service.DistributorService;
import com.su.supplydistributesystem.service.OrderItemService;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.rest.view.ResponseView;
import com.sug.core.rest.view.SuccessView;
import com.su.supplydistributesystem.domain.Order;
import com.su.supplydistributesystem.service.OrderService;
import com.su.supplydistributesystem.response.OrderListView;
import com.sug.core.util.BigDecimalUtils;
import com.sug.core.util.SequenceNumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.su.supplydistributesystem.constants.CommonConstants.*;
import static com.su.supplydistributesystem.constants.OrderConstants.*;

@RestController("orderManagementApiController")
@RequestMapping(value = "/mApi/order")
@UserLoginRequired
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private DistributorService distributorService;

    @Autowired
    private SessionContext sessionContext;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public OrderListView list(@Valid @RequestBody OrderListForm form){
        return new OrderListView(orderService.selectList(form.getQueryMap()),orderService.selectCount(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL_ID,method = RequestMethod.GET)
    public OrderDetailView detail(@PathVariable Integer id){
        return orderService.getDetail(id);
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    @Transactional
    public ResponseView create(@Valid @RequestBody OrderCreateForm form){
        Distributor distributor = distributorService.getById(form.getDistributorId());
        if(Objects.isNull(distributor)
                || !distributor.getName().equalsIgnoreCase(form.getDistributorName())
                || !distributor.getPhone().equalsIgnoreCase(form.getDistributorPhone())){
            throw new ResourceNotFoundException("distributor not found");
        }

        Order order = new Order();
        List<OrderItemForm> formList;
        List<OrderItem> orderItemList = new ArrayList<>();
        BeanUtils.copyProperties(form,order);
        order.setNumber(SequenceNumUtils.generateShortNum());
        order.setGoodsNames((formList = form.getList()).get(0).getGoodsName());

        formList.forEach(f->{
            OrderItem orderItem = new OrderItem();
            BeanUtils.copyProperties(f,orderItem);
            orderItem.setAmount(BigDecimalUtils.multiply(f.getPrice(),f.getCount()));
            order.setAmount(Objects.isNull(order.getAmount())? orderItem.getAmount() : BigDecimalUtils.add(order.getAmount(),orderItem.getAmount()));
            order.setCount(Objects.isNull(order.getCount())? orderItem.getCount() : order.getCount() + orderItem.getCount());
            orderItem.setProfit1(BigDecimalUtils.multiply(BigDecimalUtils.subtract(f.getPrice(),f.getSupplyPrice()),f.getCount()));
            orderItem.setProfit2(BigDecimalUtils.multiply(BigDecimalUtils.subtract(f.getTaobaoPrice(),f.getSupplyPrice()),f.getCount()));
            orderItem.setProfit3(BigDecimalUtils.multiply(BigDecimalUtils.subtract(f.getJdPrice(),f.getSupplyPrice()),f.getCount()));
            order.setProfit1(Objects.isNull(order.getProfit1())? orderItem.getProfit1() : BigDecimalUtils.add(order.getProfit1(),orderItem.getProfit1()));
            order.setProfit2(Objects.isNull(order.getProfit2())? orderItem.getProfit2() : BigDecimalUtils.add(order.getProfit2(),orderItem.getProfit2()));
            order.setProfit3(Objects.isNull(order.getProfit3())? orderItem.getProfit3() : BigDecimalUtils.add(order.getProfit3(),orderItem.getProfit3()));
            orderItemList.add(orderItem);
        });

        User current = sessionContext.getUser();
//        order.setCreateBy(current.getId());
        order.setCreateBy(1);

        orderService.create(order);
        orderItemList.forEach(i->{
            i.setOrderId(order.getId());
//            i.setCreateBy(current.getId());
            i.setCreateBy(1);
        });

        orderItemService.batchCreate(orderItemList);

        return new ResponseView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    @Transactional
    public ResponseView update(@Valid @RequestBody OrderUpdateForm form){
        Order order = orderService.getById(form.getId());
        if(Objects.isNull(order)){
            throw new ResourceNotFoundException("order not exists");
        }
//        if(!order.getStatus().equals(CREATED) && !order.getStatus().equals(COMMIT)){
//            throw new InvalidRequestException("invalidStatus","invalid order status");
//        }
        BeanUtils.copyProperties(form,order);
        order.setCount(null);
        order.setAmount(null);
        order.setProfit1(null);
        order.setProfit2(null);
        order.setProfit3(null);

        User current = sessionContext.getUser();
        order.setUpdateBy(current.getId());

        List<OrderItemForm> formList;
        List<OrderItem> createList = new ArrayList<>();
        List<OrderItem> updateList = new ArrayList<>();
        order.setGoodsNames((formList = form.getList()).get(0).getGoodsName());
        formList.forEach(f->{
            OrderItem orderItem = new OrderItem();
            BeanUtils.copyProperties(f,orderItem);
            orderItem.setOrderId(order.getId());
            orderItem.setAmount(BigDecimalUtils.multiply(f.getPrice(),f.getCount()));
            order.setAmount(Objects.isNull(order.getAmount())? orderItem.getAmount() : BigDecimalUtils.add(order.getAmount(),orderItem.getAmount()));
            order.setCount(Objects.isNull(order.getCount())? orderItem.getCount() : order.getCount() + orderItem.getCount());
            orderItem.setProfit1(BigDecimalUtils.multiply(BigDecimalUtils.subtract(f.getPrice(),f.getSupplyPrice()),f.getCount()));
            orderItem.setProfit2(BigDecimalUtils.multiply(BigDecimalUtils.subtract(f.getTaobaoPrice(),f.getPrice()),f.getCount()));
            orderItem.setProfit3(BigDecimalUtils.multiply(BigDecimalUtils.subtract(f.getJdPrice(),f.getPrice()),f.getCount()));
            order.setProfit1(Objects.isNull(order.getProfit1())? orderItem.getProfit1() : BigDecimalUtils.add(order.getProfit1(),orderItem.getProfit1()));
            order.setProfit2(Objects.isNull(order.getProfit2())? orderItem.getProfit2() : BigDecimalUtils.add(order.getProfit2(),orderItem.getProfit2()));
            order.setProfit3(Objects.isNull(order.getProfit3())? orderItem.getProfit3() : BigDecimalUtils.add(order.getProfit3(),orderItem.getProfit3()));
            if(Objects.isNull(orderItem.getId())){
                orderItem.setCreateBy(current.getId());
                createList.add(orderItem);
            }else {
                updateList.add(orderItem);
            }
        });

        orderService.update(order);
        if(updateList.size() > 0){
            orderItemService.batchUpdate(new OrderItemUpdateParams(order.getId(),current.getId(),updateList));
        }
        if(createList.size() > 0){
            orderItemService.batchCreate(createList);
        }
        return new ResponseView();
    }

    @RequestMapping(value = "/resetStatus",method = RequestMethod.PUT)
    public ResponseView update(@Valid @RequestBody OrderStatusForm form){
        Order order = orderService.getById(form.getId());
        if(Objects.isNull(order)){
            throw new ResourceNotFoundException("order not exists");
        }
        if(form.getStatus() - order.getStatus() != 1 || form.getStatus() > AFTER_SALE){
            throw new InvalidRequestException("invalidStatus","invalid order status");
        }
        order.setStatus(form.getStatus());
        order.setUpdateBy(sessionContext.getUser().getId());
        if(StringUtils.hasText(form.getRemark())){
            order.setRemarks(form.getRemark());
        }
//        if(StringUtils.hasText(form.getCancelReason()) && order.getStatus().equals(CANCELED)){
//            order.setCancelReason(form.getCancelReason());
//        }

        orderService.updateStatus(order);

        return new ResponseView();
    }

    @RequestMapping(value = DELETE_BY_ID,method = RequestMethod.DELETE)
    @Transactional
    public ResponseView deleteById(@PathVariable Integer id){
        Order order = orderService.getById(id);
        if(Objects.isNull(order)){
            throw new ResourceNotFoundException("order not exists");
        }
//        if(!order.getStatus().equals(CREATED)){
//            throw new InvalidRequestException("invalidStatus","invalid order status");
//        }
        orderService.deleteById(order.getId());
        orderItemService.deleteByOrderId(order.getId());

        return new ResponseView();
    }
}
