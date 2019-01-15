package com.su.supplydistributesystem.request;


import com.sug.core.util.RegexUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginForm {
    @NotEmpty
    @Size(min = 1,max = 12,message = "size between 1 and 12")
    @Pattern(regexp = RegexUtils.REGEX_ENGNNUM,message = RegexUtils.REGEX_ENGNNUM_MESSAGE)
    private String name;
    @NotEmpty
    @Pattern(regexp = RegexUtils.REGEX_PASSWORD,message = RegexUtils.REGEX_PASSWORD_MESSAGE)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
