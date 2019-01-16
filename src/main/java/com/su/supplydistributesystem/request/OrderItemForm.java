package com.su.supplydistributesystem.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderItemForm {

    private Integer id;
    @NotNull
    private Integer goodsId;
    @NotNull
    private Integer goodSupplyId;
    @NotEmpty
    private String goodsName;
    @NotNull
    @Digits(integer = 8,fraction = 2,message = "invalid digits")
    private BigDecimal taobaoPrice;
    @NotNull
    @Digits(integer = 8,fraction = 2,message = "invalid digits")
    private BigDecimal jdPrice;
    @NotNull
    @Digits(integer = 8,fraction = 2,message = "invalid digits")
    private BigDecimal price;
    @NotNull
    @Digits(integer = 8,fraction = 2,message = "invalid digits")
    private BigDecimal supplyPrice;
    @NotNull
    @Min(value = 1,message = "at least 1 count")
    private Integer count;
    @NotEmpty
    private String supplierName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodSupplyId() {
        return goodSupplyId;
    }

    public void setGoodSupplyId(Integer goodSupplyId) {
        this.goodSupplyId = goodSupplyId;
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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}