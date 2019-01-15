package com.su.supplydistributesystem.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserUpdateForm {

    @NotNull
    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String passwrod;

    public Integer getId() {
    return id;
    }

    public void setId(Integer id) {
    this.id = id;
    }
    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }
    public String getPasswrod() {
    return passwrod;
    }

    public void setPasswrod(String passwrod) {
    this.passwrod = passwrod;
    }

}