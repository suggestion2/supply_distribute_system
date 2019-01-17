package com.su.supplydistributesystem.serviceImpl;

import com.su.supplydistributesystem.mapper.OrderItemMapper;
import com.su.supplydistributesystem.mapper.OrderMapper;
import com.su.supplydistributesystem.service.OrderItemService;
import com.su.supplydistributesystem.service.OrderService;
import com.su.supplydistributesystem.service.statistic.OrderItemDailyCount;
import com.su.supplydistributesystem.service.statistic.OrderStatisticResult;
import com.su.supplydistributesystem.service.statistic.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class StatisticsServiceImpl implements StatisticsService{

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public OrderStatisticResult countOrder(Integer status, String beginDate, String endDate) {
        Map<String,Object> query = new HashMap<>();
        query.put(Objects.nonNull(status) ? "status" : "available",Objects.nonNull(status) ? status : 1);
        query.put("beginDate",beginDate);
        query.put("endDate",endDate);
        return orderMapper.countOrder(query);
    }

    @Override
    public List<OrderItemDailyCount> countOrderCount(Integer status, Integer categoryId1, Integer categoryId2, Integer categoryId3, String date) {
        Map<String,Object> query = new HashMap<>();
        query.put(Objects.nonNull(status) ? "status" : "available",Objects.nonNull(status) ? status : 1);
        query.put("categoryId1",categoryId1);
        query.put("categoryId2",categoryId2);
        query.put("categoryId3",categoryId3);
        query.put("date",date);

        return orderItemMapper.countOrderCount(query);
    }

    @Override
    public List<OrderItemDailyCount> countSalesCount(Integer status, Integer categoryId1, Integer categoryId2, Integer categoryId3, String date) {
        Map<String,Object> query = new HashMap<>();
        query.put(Objects.nonNull(status) ? "status" : "available",Objects.nonNull(status) ? status : 1);
        query.put("categoryId1",categoryId1);
        query.put("categoryId2",categoryId2);
        query.put("categoryId3",categoryId3);
        query.put("date",date);
        return orderItemMapper.countSalesCount(query);
    }
}
