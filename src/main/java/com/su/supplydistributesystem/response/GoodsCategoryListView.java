package com.su.supplydistributesystem.response;

import com.sug.core.platform.web.pagination.PaginationView;
import org.springframework.beans.factory.annotation.Autowired;
import com.su.supplydistributesystem.domain.GoodsCategory;

import java.util.List;

public class GoodsCategoryListView extends PaginationView<GoodsCategoryListItemView> {

    @Autowired
    public GoodsCategoryListView() {
    }

    public GoodsCategoryListView(List<GoodsCategoryListItemView> list, int count) {
        this.setList(list);
        this.setCount(count);
    }

    public GoodsCategoryListView(List<GoodsCategoryListItemView> list) {
        this.setList(list);
    }
}
