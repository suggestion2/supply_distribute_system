package com.su.supplydistributesystem.response;

import com.su.supplydistributesystem.service.statistic.OrderItemDailyCount;

import java.util.List;

public class OrderItemCategoryStatisticsView {
    private Integer dailyCount;
    private Integer weeklyCount;
    private Integer monthlyCount;

    private List<OrderItemDailyCount> list;

    public OrderItemCategoryStatisticsView(Integer dailyCount, Integer weeklyCount, Integer monthlyCount,List<OrderItemDailyCount> list) {
        this.dailyCount = dailyCount;
        this.weeklyCount = weeklyCount;
        this.monthlyCount = monthlyCount;
        this.list = list;
    }

    public Integer getDailyCount() {
        return dailyCount;
    }

    public void setDailyCount(Integer dailyCount) {
        this.dailyCount = dailyCount;
    }

    public Integer getWeeklyCount() {
        return weeklyCount;
    }

    public void setWeeklyCount(Integer weeklyCount) {
        this.weeklyCount = weeklyCount;
    }

    public Integer getMonthlyCount() {
        return monthlyCount;
    }

    public void setMonthlyCount(Integer monthlyCount) {
        this.monthlyCount = monthlyCount;
    }

    public List<OrderItemDailyCount> getList() {
        return list;
    }

    public void setList(List<OrderItemDailyCount> list) {
        this.list = list;
    }
}
