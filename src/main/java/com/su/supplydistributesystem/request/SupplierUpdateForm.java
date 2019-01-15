package com.su.supplydistributesystem.request;

import com.sug.core.util.RegexUtils;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SupplierUpdateForm {

    @NotNull
    private Integer id;
    @NotEmpty
    @Pattern(regexp=RegexUtils.REGEX_CHINESE_ENG_NUM  ,message = "Must be an alphanumeric character"  )
    private String name;

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