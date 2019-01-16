package com.su.supplydistributesystem.service;

import com.su.supplydistributesystem.domain.Order;
import com.su.supplydistributesystem.domain.OrderItem;

import java.util.List;

public class OrderDetailParams {
    private Order order;

    private List<OrderItem> list;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }
}
