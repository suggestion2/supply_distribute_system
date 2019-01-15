package com.su.supplydistributesystem.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DistributorCreateForm {

    @NotEmpty
    private String name;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String passwrod;

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }
    public String getPhone() {
    return phone;
    }

    public void setPhone(String phone) {
    this.phone = phone;
    }
    public String getPasswrod() {
    return passwrod;
    }

    public void setPasswrod(String passwrod) {
    this.passwrod = passwrod;
    }

}