package com.su.supplydistributesystem.response;

import com.su.supplydistributesystem.domain.Goods;
import com.sug.core.platform.web.pagination.PaginationView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GoodsDistributeListView extends  PaginationView<GoodsDistributeView>{
    @Autowired
    public GoodsDistributeListView() {
    }

    public GoodsDistributeListView(List<GoodsDistributeView> list, int count) {
        this.setList(list);
        this.setCount(count);
    }

    public GoodsDistributeListView(List<GoodsDistributeView> list) {
        this.setList(list);
    }

}
