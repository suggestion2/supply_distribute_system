package com.su.supplydistributesystem.request;

import com.sug.core.util.RegexUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DistributorLoginForm {
    @NotEmpty
    @Size(min=1,max = 32,message = "size between 1 and 32")
    private String account;
    @NotEmpty
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
