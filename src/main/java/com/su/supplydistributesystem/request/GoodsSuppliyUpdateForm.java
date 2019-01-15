package com.su.supplydistributesystem.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GoodsSuppliyUpdateForm {

    @NotNull
    private Integer id;
    @NotNull
    private Integer supplierId;
    @NotEmpty
    private String supplierName;
    @NotNull
    private Integer goodsId;
    @NotNull
    private BigDecimal supplyPrice;

    public Integer getId() {
    return id;
    }

    public void setId(Integer id) {
    this.id = id;
    }
    public Integer getSupplierId() {
    return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
    }
    public String getSupplierName() {
    return supplierName;
    }

    public void setSupplierName(String supplierName) {
    this.supplierName = supplierName;
    }
    public Integer getGoodsId() {
    return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
    this.goodsId = goodsId;
    }
    public BigDecimal getSupplyPrice() {
    return supplyPrice;
    }

    public void setSupplyPrice(BigDecimal supplyPrice) {
    this.supplyPrice = supplyPrice;
    }

}