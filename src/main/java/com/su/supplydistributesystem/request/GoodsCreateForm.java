package com.su.supplydistributesystem.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GoodsCreateForm {

    @NotEmpty
    private String number;
    @NotNull
    private Integer categoryId1;
    @NotNull
    private Integer categoryId2;
    @NotNull
    private Integer categoryId3;
    @NotEmpty
    private String category1;
    @NotEmpty
    private String category2;
    @NotEmpty
    private String category3;
    @NotEmpty
    private String name;
    @NotNull
    private BigDecimal taobaoPrice;
    @NotNull
    private BigDecimal jdPrice;
    @NotNull
    private BigDecimal price;
    @NotNull
    private BigDecimal lowSupplyPrice;
    @NotNull
    private BigDecimal profit1;
    @NotNull
    private BigDecimal profit2;
    @NotNull
    private BigDecimal profit3;
    @NotNull
    private Integer salesVolume;
    @NotEmpty
    private String remarks;

    public String getNumber() {
    return number;
    }

    public void setNumber(String number) {
    this.number = number;
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
    return price;
    }

    public void setPrice(BigDecimal price) {
    this.price = price;
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

}