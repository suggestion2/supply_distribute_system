package com.su.supplydistributesystem.request;

import com.sug.core.util.RegexUtils;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class GoodsCategoryCreateForm {

    @NotEmpty
    @Pattern(regexp = RegexUtils.REGEX_CHINESE_ENG_NUM,message = RegexUtils.REGEX_CHINESE_ENG_NUM_MESSAGE)
    @Size(min = 1,max = 32)
    private String name;
    @NotNull
    private Integer parentId;

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }
    public Integer getParentId() {
    return parentId;
    }

    public void setParentId(Integer parentId) {
    this.parentId = parentId;
    }

}