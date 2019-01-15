package com.su.supplydistributesystem.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GoodsSupplyForm {

    private Integer id;
    @NotNull
    private Integer supplierId;
    @NotEmpty
    private String supplierName;
    private Integer goodsId;
    @NotNull
    @Digits(integer = 8,fraction = 2,message = "invalid digits")
    private BigDecimal supplyPrice;
    private Integer createBy;

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

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }
}