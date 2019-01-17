package com.su.supplydistributesystem.service.statistic;

import java.util.Date;

public class OrderItemDailyCount {
    private Integer count;
    private Date date;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
