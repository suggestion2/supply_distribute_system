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

public class OrderCreateForm {

    @NotNull
    private Integer distributorId;
    @NotEmpty
    private String distributorName;
    @NotEmpty
    private String distributorPhone;
    @NotEmpty
    @Pattern(regexp = RegexUtils.REGEX_CHINESE_ENG_NUM,message = RegexUtils.REGEX_CHINESE_ENG_NUM_MESSAGE)
    @Size(min = 1,max = 32,message = "size between 1 and 32")
    private String customerName;
    @NotEmpty
    @Pattern(regexp = RegexUtils.REGEX_CHINESE_ENG_NUM,message = RegexUtils.REGEX_CHINESE_ENG_NUM_MESSAGE)
    @Size(min = 1,max = 256,message = "size between 1 and 256")
    private String customerAddress;
    @NotEmpty
    @Pattern(regexp = RegexUtils.REGEX_MOBILE,message = RegexUtils.REGEX_MOBILE_MESSAGE)
    private String customerPhone;
    @NotEmpty
    @Pattern(regexp = RegexUtils.REGEX_CHINESE_ENG_NUM,message = RegexUtils.REGEX_CHINESE_ENG_NUM_MESSAGE)
    @Size(min = 1,max = 256,message = "size between 1 and 256")
    private String dispatchCompany;
    @NotEmpty
    @Pattern(regexp = RegexUtils.REGEX_ENGNNUM,message = RegexUtils.REGEX_ENGNNUM_MESSAGE)
    @Size(min = 1,max = 256,message = "size between 1 and 256")
    private String dispatchNumber;
    @NotNull
    private Integer status;

    private String remarks;

    @NotNull
    @Size(min = 1,message = "at least 1 item")
    @Valid
    private List<OrderItemForm> list;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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