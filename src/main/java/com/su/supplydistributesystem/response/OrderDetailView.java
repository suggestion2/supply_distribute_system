package com.su.supplydistributesystem.response;

import com.su.supplydistributesystem.domain.Order;
import com.su.supplydistributesystem.domain.OrderItem;

import java.util.List;

public class OrderDetailView {
    private Order order;

    private List<OrderItem> list;

    public OrderDetailView(Order order, List<OrderItem> list) {
        this.order = order;
        this.list = list;
    }

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
