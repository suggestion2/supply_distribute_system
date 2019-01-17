package com.su.supplydistributesystem.mapper;

import com.su.supplydistributesystem.domain.OrderItem;
import com.su.supplydistributesystem.service.statistic.OrderItemDailyCount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderItemMapper {

    OrderItem selectById(Integer id);

    OrderItem select(Map<String, Object> map);

    List<OrderItem> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    List<OrderItemDailyCount> countOrderCount(Map<String, Object> map);

    List<OrderItemDailyCount> countSalesCount(Map<String, Object> map);

    int batchInsert(List<OrderItem> list);

    int batchUpdate(OrderItemUpdateParams params);

    int deleteByOrderId(Integer id);
}