package com.su.supplydistributesystem.request;

import com.sug.core.util.RegexUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ResetPasswordForm {
    @NotEmpty
    @Pattern(regexp = RegexUtils.REGEX_PASSWORD,message = RegexUtils.REGEX_PASSWORD_MESSAGE)
    private String originPassword;
    @NotEmpty
    @Pattern(regexp = RegexUtils.REGEX_PASSWORD,message = RegexUtils.REGEX_PASSWORD_MESSAGE)
    private String newPassword;

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
}
