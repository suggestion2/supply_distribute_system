package com.su.supplydistributesystem.service;

import com.su.supplydistributesystem.domain.OrderItem;
import com.su.supplydistributesystem.mapper.OrderItemUpdateParams;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface OrderItemService {
    OrderItem getById(Integer id);

    OrderItem select(Map<String, Object> map);

    List<OrderItem> selectList(Map<String, Object> map);

    List<OrderItem> getListByOrderId(Integer orderId);

    int selectCount(Map<String, Object> map);

    int batchCreate(List<OrderItem> list);

    int batchUpdate(OrderItemUpdateParams params);

    int deleteByOrderId(Integer id);
}