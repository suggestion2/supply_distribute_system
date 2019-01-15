package com.su.supplydistributesystem.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderItemCreateForm {

    @NotNull
    private Integer orderId;
    @NotNull
    private Integer goodsId;
    @NotNull
    private Integer goodSuppliyId;
    @NotEmpty
    private String goodsName;
    @NotNull
    private BigDecimal taobaoPrice;
    @NotNull
    private BigDecimal jdPrice;
    @NotNull
    private BigDecimal price;
    @NotNull
    private BigDecimal supplyPrice;
    @NotNull
    private Integer count;
    @NotNull
    private BigDecimal amount;
    @NotNull
    private BigDecimal profit1;
    @NotNull
    private BigDecimal profit2;
    @NotNull
    private BigDecimal profit3;

    public Integer getOrderId() {
    return orderId;
    }

    public void setOrderId(Integer orderId) {
    this.orderId = orderId;
    }
    public Integer getGoodsId() {
    return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
    this.goodsId = goodsId;
    }
    public Integer getGoodSuppliyId() {
    return goodSuppliyId;
    }

    public void setGoodSuppliyId(Integer goodSuppliyId) {
    this.goodSuppliyId = goodSuppliyId;
    }
    public String getGoodsName() {
    return goodsName;
    }

    public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
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
    public BigDecimal getSupplyPrice() {
    return supplyPrice;
    }

    public void setSupplyPrice(BigDecimal supplyPrice) {
    this.supplyPrice = supplyPrice;
    }
    public Integer getCount() {
    return count;
    }

    public void setCount(Integer count) {
    this.count = count;
    }
    public BigDecimal getAmount() {
    return amount;
    }

    public void setAmount(BigDecimal amount) {
    this.amount = amount;
    }
    public BigDecimal getProfit1() {
    return profit1;
    }

    public void setProfit1(BigDecimal profit1) {
    this.profit1 = profit1;
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

}