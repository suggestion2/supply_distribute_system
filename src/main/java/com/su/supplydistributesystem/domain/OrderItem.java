package com.su.supplydistributesystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sug.core.util.jsonFormat.SimpleDateTimeSerializer;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItem {

    private Integer id;
    private Integer orderId;
    private Integer goodsId;
    private Integer goodSupplyId;
    private String goodsName;
    private BigDecimal taobaoPrice;
    private BigDecimal jdPrice;
    private BigDecimal price;
    private BigDecimal supplyPrice;
    private Integer count;
    private BigDecimal amount;
    @JsonIgnore
    private BigDecimal profit1;
    @JsonIgnore
    private BigDecimal profit2;
    @JsonIgnore
    private BigDecimal profit3;
    @JsonSerialize(using = SimpleDateTimeSerializer.class)
    private Date createTime;
    @JsonIgnore
    private Date updateTime;
    @JsonIgnore
    private Integer createBy;
    @JsonIgnore
    private Integer updateBy;
    private Integer status;
    @JsonIgnore
    private Integer valid;
    private String supplierName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
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
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }
    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

}