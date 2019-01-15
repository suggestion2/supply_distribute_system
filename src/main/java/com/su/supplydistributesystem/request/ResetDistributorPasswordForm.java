package com.su.supplydistributesystem.request;

import javax.validation.constraints.NotNull;


public class ResetDistributorPasswordForm {
    @NotNull
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
