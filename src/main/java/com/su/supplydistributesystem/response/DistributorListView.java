package com.su.supplydistributesystem.response;

import com.sug.core.platform.web.pagination.PaginationView;
import org.springframework.beans.factory.annotation.Autowired;
import com.su.supplydistributesystem.domain.Distributor;

import java.util.List;

public class DistributorListView extends PaginationView<Distributor>{

        @Autowired
        public DistributorListView() {
        }

        public DistributorListView(List<Distributor> list,int count) {
            this.setList(list);
            this.setCount(count);
        }

        public DistributorListView(List<Distributor> list) {
            this.setList(list);
        }
}
