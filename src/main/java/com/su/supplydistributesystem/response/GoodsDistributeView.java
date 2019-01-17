package com.su.supplydistributesystem.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sug.core.util.jsonFormat.SimpleDateTimeSerializer;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsDistributeView {
    private Integer id;
    private String category1;
    private String category2;
    private String category3;
    private String name;
    private BigDecimal taobaoPrice;
    private BigDecimal jdPrice;
    private BigDecimal price;
    private BigDecimal profit2;
    private BigDecimal profit3;
    private String remarks;
    private String colour;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getCategory3() {
        return category3;
    }

    public void setCategory3(String category3) {
        this.category3 = category3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTaobaoPrice() {
        return taobaoPrice;
    }

    public void setTaobaoPrice(BigDecimal taobaoPrice) {
        this.taobaoPrice = taobaoPrice;
    }

    public BigDecimal getJdPrice() {
        return jdPrice;
    }

    public void setJdPrice(BigDecimal jdPrice) {
        this.jdPrice = jdPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getProfit2() {
        return profit2;
    }

    public void setProfit2(BigDecimal profit2) {
        this.profit2 = profit2;
    }

    public BigDecimal getProfit3() {
        return profit3;
    }

    public void setProfit3(BigDecimal profit3) {
        this.profit3 = profit3;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
