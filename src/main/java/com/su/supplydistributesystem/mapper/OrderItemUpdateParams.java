package com.su.supplydistributesystem.mapper;

import com.su.supplydistributesystem.domain.OrderItem;
import com.su.supplydistributesystem.request.GoodsSupplyForm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderItemUpdateParams {
    private Integer orderId;

    private Integer updateBy;

    private List<OrderItem> list;

    @Autowired
    public OrderItemUpdateParams() {
    }

    public OrderItemUpdateParams(Integer orderId, Integer updateBy, List<OrderItem> list) {
        this.orderId = orderId;
        this.updateBy = updateBy;
        this.list = list;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }
}
