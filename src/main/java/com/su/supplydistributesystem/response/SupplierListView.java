package com.su.supplydistributesystem.response;

import com.sug.core.platform.web.pagination.PaginationView;
import org.springframework.beans.factory.annotation.Autowired;
import com.su.supplydistributesystem.domain.Supplier;

import java.util.List;

public class SupplierListView extends PaginationView<Supplier>{

        @Autowired
        public SupplierListView() {
        }

        public SupplierListView(List<Supplier> list,int count) {
            this.setList(list);
            this.setCount(count);
        }

        public SupplierListView(List<Supplier> list) {
            this.setList(list);
        }
}
