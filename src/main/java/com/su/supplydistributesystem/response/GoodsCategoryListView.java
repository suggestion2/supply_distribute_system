package com.su.supplydistributesystem.response;

import com.sug.core.platform.web.pagination.PaginationView;
import org.springframework.beans.factory.annotation.Autowired;
import com.su.supplydistributesystem.domain.GoodsCategory;

import java.util.List;

public class GoodsCategoryListView extends PaginationView<GoodsCategory>{

        @Autowired
        public GoodsCategoryListView() {
        }

        public GoodsCategoryListView(List<GoodsCategory> list,int count) {
            this.setList(list);
            this.setCount(count);
        }

        public GoodsCategoryListView(List<GoodsCategory> list) {
            this.setList(list);
        }
}
