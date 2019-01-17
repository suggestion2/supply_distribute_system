package com.su.supplydistributesystem.service.statistic;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatisticsService {
    OrderStatisticResult countOrder(Integer status,String beginDate,String endDate);

    List<OrderItemDailyCount> countOrderCount(Integer status,Integer categoryId1,Integer categoryId2,Integer categoryId3,String date);

    List<OrderItemDailyCount> countSalesCount(Integer status,Integer categoryId1,Integer categoryId2,Integer categoryId3,String date);
}
