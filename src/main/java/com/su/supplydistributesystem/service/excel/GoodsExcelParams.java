package com.su.supplydistributesystem.service.excel;

import com.su.supplydistributesystem.domain.Goods;
import com.su.supplydistributesystem.domain.GoodsSupply;

import java.util.List;

public class GoodsExcelParams {
    private Goods goods;

    private List<GoodsSupply> list;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<GoodsSupply> getList() {
        return list;
    }

    public void setList(List<GoodsSupply> list) {
        this.list = list;
    }
}
