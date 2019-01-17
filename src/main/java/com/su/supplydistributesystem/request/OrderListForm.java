package com.su.supplydistributesystem.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sug.core.platform.web.pagination.PaginationForm;
import com.sug.core.util.jsonFormat.SimpleDateDeserializer;

import java.util.Date;

public class OrderListForm extends PaginationForm{
    @JsonDeserialize(using = SimpleDateDeserializer.class)
    private Date date;

    private String content;

    private Integer status;

    private Integer distributorId;

    public Integer getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
