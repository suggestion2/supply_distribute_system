package com.su.supplydistributesystem.request;


import com.sug.core.util.RegexUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DistributorUpdatePasswordForm {
    @NotEmpty
    @Size(min=1,max = 32)
    private String originPassword;
    @NotEmpty
    @Size(min=1,max = 32)
    private String newPassword;
    @NotEmpty
    @Size(min=1,max = 32)
    private String repeatPassword;

    public String getOriginPassword() {
        return originPassword;
    }

    public void setOriginPassword(String originPassword) {
        this.originPassword = originPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
