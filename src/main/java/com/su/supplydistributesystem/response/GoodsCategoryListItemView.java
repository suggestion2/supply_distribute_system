package com.su.supplydistributesystem.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.su.supplydistributesystem.domain.GoodsCategory;
import com.sug.core.util.jsonFormat.SimpleDateTimeSerializer;

import java.util.Date;
import java.util.List;

public class GoodsCategoryListItemView {
    private Integer id;
    private String name;
    private Integer level;
    private Integer parentId;
    @JsonSerialize(using = SimpleDateTimeSerializer.class)
    private Date createTime;
    private Integer status;

    private List<GoodsCategoryListItemView> list;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<GoodsCategoryListItemView> getList() {
        return list;
    }

    public void setList(List<GoodsCategoryListItemView> list) {
        this.list = list;
    }
}
