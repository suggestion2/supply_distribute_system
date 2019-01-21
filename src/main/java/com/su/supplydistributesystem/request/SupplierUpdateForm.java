package com.su.supplydistributesystem.request;

import com.sug.core.util.RegexUtils;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SupplierUpdateForm {

    @NotNull
    private Integer id;
    @NotEmpty
    private String name;
    @Pattern(regexp=RegexUtils.REGEX_PHONE_LAMDLINE  ,message = RegexUtils.REGEX_PHONE_LAMDLINE_MESSAGE  )
    private String phone;
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

}