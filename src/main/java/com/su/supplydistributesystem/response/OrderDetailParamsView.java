package com.su.supplydistributesystem.response;


import com.su.supplydistributesystem.domain.Goods;
import com.su.supplydistributesystem.domain.Order;
import com.su.supplydistributesystem.service.OrderDetailParams;
import com.su.supplydistributesystem.service.OrderDistributeDetailParams;
import com.sug.core.platform.web.pagination.PaginationView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDetailParamsView extends PaginationView<OrderDistributeDetailParams> {
    @Autowired
    public OrderDetailParamsView() {
    }

    public OrderDetailParamsView(List<OrderDistributeDetailParams> list, int count) {
        this.setList(list);
        this.setCount(count);
    }

    public OrderDetailParamsView(List<OrderDistributeDetailParams> list) {
        this.setList(list);
    }

}
