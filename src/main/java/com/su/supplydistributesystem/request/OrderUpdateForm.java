package com.su.supplydistributesystem.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderUpdateForm {

    @NotNull
    private Integer id;
    @NotEmpty
    private String number;
    @NotNull
    private Integer distributorId;
    @NotEmpty
    private String distributorName;
    @NotEmpty
    private String distributorPhone;
    @NotEmpty
    private String cancelReason;
    @NotEmpty
    private String customerName;
    @NotEmpty
    private String customerAddress;
    @NotEmpty
    private String customerPhone;
    @NotEmpty
    private String dispatchCompany;
    @NotEmpty
    private String dispatchNumber;
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

    public Integer getId() {
    return id;
    }

    public void setId(Integer id) {
    this.id = id;
    }
    public String getNumber() {
    return number;
    }

    public void setNumber(String number) {
    this.number = number;
    }
    public Integer getDistributorId() {
    return distributorId;
    }

    public void setDistributorId(Integer distributorId) {
    this.distributorId = distributorId;
    }
    public String getDistributorName() {
    return distributorName;
    }

    public void setDistributorName(String distributorName) {
    this.distributorName = distributorName;
    }
    public String getDistributorPhone() {
    return distributorPhone;
    }

    public void setDistributorPhone(String distributorPhone) {
    this.distributorPhone = distributorPhone;
    }
    public String getCancelReason() {
    return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
    this.cancelReason = cancelReason;
    }
    public String getCustomerName() {
    return customerName;
    }

    public void setCustomerName(String customerName) {
    this.customerName = customerName;
    }
    public String getCustomerAddress() {
    return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
    this.customerAddress = customerAddress;
    }
    public String getCustomerPhone() {
    return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
    this.customerPhone = customerPhone;
    }
    public String getDispatchCompany() {
    return dispatchCompany;
    }

    public void setDispatchCompany(String dispatchCompany) {
    this.dispatchCompany = dispatchCompany;
    }
    public String getDispatchNumber() {
    return dispatchNumber;
    }

    public void setDispatchNumber(String dispatchNumber) {
    this.dispatchNumber = dispatchNumber;
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