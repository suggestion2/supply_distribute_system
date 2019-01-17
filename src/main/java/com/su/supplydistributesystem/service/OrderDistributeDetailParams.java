package com.su.supplydistributesystem.service;


import com.su.supplydistributesystem.domain.Order;
import com.su.supplydistributesystem.domain.OrderItem;
import com.su.supplydistributesystem.response.OrderDistributeView;
import com.su.supplydistributesystem.response.OrderItemDistributeView;

import java.util.List;

public class OrderDistributeDetailParams {
    private OrderDistributeView orderDistributeView;

    private List<OrderItemDistributeView> list;

    public OrderDistributeView getOrderDistributeView() {
        return orderDistributeView;
    }

    public void setOrderDistributeView(OrderDistributeView orderDistributeView) {
        this.orderDistributeView = orderDistributeView;
    }

    public List<OrderItemDistributeView> getList() {
        return list;
    }

    public void setList(List<OrderItemDistributeView> list) {
        this.list = list;
    }
}
