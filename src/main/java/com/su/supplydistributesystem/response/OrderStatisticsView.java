package com.su.supplydistributesystem.response;

import java.math.BigDecimal;

public class OrderStatisticsView {
    private Integer count;
    private BigDecimal sumAmount;
    private Integer sumSalesCount;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(BigDecimal sumAmount) {
        this.sumAmount = sumAmount;
    }

    public Integer getSumSalesCount() {
        return sumSalesCount;
    }

    public void setSumSalesCount(Integer sumSalesCount) {
        this.sumSalesCount = sumSalesCount;
    }
}
