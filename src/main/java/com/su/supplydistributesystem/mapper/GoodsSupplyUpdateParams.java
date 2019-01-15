package com.su.supplydistributesystem.mapper;

import com.su.supplydistributesystem.request.GoodsSupplyForm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GoodsSupplyUpdateParams {
    private Integer goodsId;

    private Integer updateBy;

    private List<GoodsSupplyForm> list;

    @Autowired
    public GoodsSupplyUpdateParams() {
    }

    public GoodsSupplyUpdateParams(Integer goodsId, Integer updateBy, List<GoodsSupplyForm> list) {
        this.goodsId = goodsId;
        this.updateBy = updateBy;
        this.list = list;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public List<GoodsSupplyForm> getList() {
        return list;
    }

    public void setList(List<GoodsSupplyForm> list) {
        this.list = list;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }
}
