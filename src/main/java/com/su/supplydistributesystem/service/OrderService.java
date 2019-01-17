package com.su.supplydistributesystem.service;

import com.su.supplydistributesystem.domain.Order;
import com.su.supplydistributesystem.response.OrderDetailView;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface OrderService {
    Order getById(Integer id);

    OrderDetailView getDetail(Integer id);

    Order select(Map<String, Object> map);

    List<Order> selectList(Map<String, Object> map);

    List<Order> selectDistributorList(Integer distributorId);

    List<OrderDetailParams> getDetailParamsList(Map<String, Object> map);

    List<OrderDistributeDetailParams> selectOrderDetailParamsViewList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int create(Order order);

    int update(Order order);

    int updateStatus(Order order);

    int deleteById(Integer id);
}