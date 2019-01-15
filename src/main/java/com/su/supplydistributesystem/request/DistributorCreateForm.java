package com.su.supplydistributesystem.request;

import com.sug.core.util.RegexUtils;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DistributorCreateForm {

    @NotEmpty
    @Pattern(regexp=RegexUtils.REGEX_CHINESE_ENG_NUM  ,message = "Must be an alphanumeric character"  )
    @Size(min=1,max = 32)
    private String name;
    @NotEmpty
    @Pattern(regexp=RegexUtils.REGEX_MOBILE ,message ="must be an phone"  )
    private String phone;

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

}