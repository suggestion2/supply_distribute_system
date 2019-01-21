package com.su.supplydistributesystem.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserCreateForm {

    @NotEmpty
    @Size(min=1,max = 32)
    private String name;
    @NotEmpty
    @Size(min=1,max = 32)
    private String passwrod;

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