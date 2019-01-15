package com.su.supplydistributesystem.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {

    private Integer id;
    private Integer categoryId1;
    private Integer categoryId2;
    private Integer categoryId3;
    private String category1;
    private String category2;
    private String category3;
    private String name;
    private BigDecimal taobaoPrice;
    private BigDecimal jdPrice;
    private BigDecimal Price;
    private BigDecimal lowSupplyPrice;
    private BigDecimal profit1;
    private BigDecimal profit2;
    private BigDecimal profit3;
    private Integer salesVolume;
    private String remarks;
    private Date createTime;
    private Date updateTime;
    private Integer createBy;
    private Integer updateBy;
    private Integer status;
    private Integer valid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Integer categoryId1) {
        this.categoryId1 = categoryId1;
    }
    public Integer getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Integer categoryId2) {
        this.categoryId2 = categoryId2;
    }
    public Integer getCategoryId3() {
        return categoryId3;
    }

    public void setCategoryId3(Integer categoryId3) {
        this.categoryId3 = categoryId3;
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
        return Price;
    }

    public void setPrice(BigDecimal Price) {
        this.Price = Price;
    }
    public BigDecimal getLowSupplyPrice() {
        return lowSupplyPrice;
    }

    public void setLowSupplyPrice(BigDecimal lowSupplyPrice) {
        this.lowSupplyPrice = lowSupplyPrice;
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
    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

}