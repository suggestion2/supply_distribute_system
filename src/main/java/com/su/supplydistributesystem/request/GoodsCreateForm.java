package com.su.supplydistributesystem.request;

import com.sug.core.util.RegexUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

public class GoodsCreateForm {

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
    @Pattern(regexp = RegexUtils.REGEX_CHINESE_ENG_NUM,message = RegexUtils.REGEX_CHINESE_ENG_NUM_MESSAGE)
    private String name;
    @NotNull
    @Digits(integer = 8,fraction = 2,message = "invalid digits")
    private BigDecimal taobaoPrice;
    @NotNull
    @Digits(integer = 8,fraction = 2,message = "invalid digits")
    private BigDecimal jdPrice;
    @NotNull
    @Digits(integer = 8,fraction = 2,message = "invalid digits")
    private BigDecimal price;
    @NotEmpty
    @Pattern(regexp = RegexUtils.REGEX_CHINESE_ENG_NUM,message = RegexUtils.REGEX_CHINESE_ENG_NUM_MESSAGE)
    private String remarks;

    @NotNull
    @Min(value = 1,message = "at least 1 item")
    @Valid
    private List<GoodsSupplyForm> goodsSupplyList;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<GoodsSupplyForm> getGoodsSupplyList() {
        return goodsSupplyList;
    }

    public void setGoodsSupplyList(List<GoodsSupplyForm> goodsSupplyList) {
        this.goodsSupplyList = goodsSupplyList;
    }
}