package com.su.supplydistributesystem.request;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SupplierCreateForm {

    @NotEmpty
    private String name;

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }

}