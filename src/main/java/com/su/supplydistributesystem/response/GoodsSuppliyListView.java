package com.su.supplydistributesystem.response;

import com.sug.core.platform.web.pagination.PaginationView;
import org.springframework.beans.factory.annotation.Autowired;
import com.su.supplydistributesystem.domain.GoodsSuppliy;

import java.util.List;

public class GoodsSuppliyListView extends PaginationView<GoodsSuppliy>{

        @Autowired
        public GoodsSuppliyListView() {
        }

        public GoodsSuppliyListView(List<GoodsSuppliy> list,int count) {
            this.setList(list);
            this.setCount(count);
        }

        public GoodsSuppliyListView(List<GoodsSuppliy> list) {
            this.setList(list);
        }
}
