package com.su.supplydistributesystem.response;

import com.sug.core.platform.web.pagination.PaginationView;
import org.springframework.beans.factory.annotation.Autowired;
import com.su.supplydistributesystem.domain.GoodsSupply;

import java.util.List;

public class GoodsSupplyListView extends PaginationView<GoodsSupply>{

        @Autowired
        public GoodsSupplyListView() {
        }

        public GoodsSupplyListView(List<GoodsSupply> list,int count) {
            this.setList(list);
            this.setCount(count);
        }

        public GoodsSupplyListView(List<GoodsSupply> list) {
            this.setList(list);
        }
}
