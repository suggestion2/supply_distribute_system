package com.su.supplydistributesystem.request;

import javax.validation.constraints.NotNull;
import java.util.List;

public class GoodsBatchStatusForm {
    @NotNull
    private List<Integer> list;
    @NotNull
    private Integer status;

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
