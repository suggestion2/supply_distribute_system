package com.su.supplydistributesystem.request;

import com.sug.core.util.RegexUtils;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SupplierCreateForm {

    @NotEmpty
    @Size(min=1,max = 32)
    private String name;
    @NotEmpty
    @Pattern(regexp=RegexUtils.REGEX_PHONE_LAMDLINE  ,message = RegexUtils.REGEX_PHONE_LAMDLINE_MESSAGE  )
    private String phone;
    @NotEmpty
    @Size(min=1,max = 32)
    private String contact;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }

}