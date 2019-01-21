package com.su.supplydistributesystem.request;

import com.sug.core.util.RegexUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class OrderUpdateForm {

    @NotNull
    private Integer id;
    @NotNull
    private Integer distributorId;
    @NotEmpty
    private String distributorName;
    @NotEmpty
    private String distributorPhone;
    @NotEmpty
    @Size(min = 1,max = 32,message = "size between 1 and 32")
    private String customerName;
    @NotEmpty
    @Size(min = 1,max = 256,message = "size between 1 and 256")
    private String customerAddress;
    @NotEmpty
    @Pattern(regexp = RegexUtils.REGEX_MOBILE,message = RegexUtils.REGEX_MOBILE_MESSAGE)
    private String customerPhone;
    @NotEmpty
    @Size(min = 1,max = 256,message = "size between 1 and 256")
    private String dispatchCompany;
    @NotEmpty
    @Size(min = 1,max = 256,message = "size between 1 and 256")
    private String dispatchNumber;

    private String remarks;

    @NotNull
    @Size(min = 1,message = "at least 1 item")
    @Valid
    private List<OrderItemForm> list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<OrderItemForm> getList() {
        return list;
    }

    public void setList(List<OrderItemForm> list) {
        this.list = list;
    }
}