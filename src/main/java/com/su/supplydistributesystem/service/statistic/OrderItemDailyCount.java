package com.su.supplydistributesystem.service.statistic;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sug.core.util.jsonFormat.SimpleDateSerializer;

import java.util.Date;

public class OrderItemDailyCount {
    private Integer count;
    @JsonSerialize(using = SimpleDateSerializer.class)
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
