package com.su.supplydistributesystem.serviceImpl;

import com.su.supplydistributesystem.domain.Order;
import com.su.supplydistributesystem.domain.OrderItem;
import com.su.supplydistributesystem.response.OrderDetailView;
import com.su.supplydistributesystem.service.OrderDetailParams;
import com.su.supplydistributesystem.service.OrderItemService;
import com.su.supplydistributesystem.service.OrderService;
import com.su.supplydistributesystem.mapper.OrderMapper;
import com.sug.core.platform.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemService orderItemService;

    @Override
    public Order getById(Integer id){
        return orderMapper.selectById(id);
    }

    @Override
    public OrderDetailView getDetail(Integer id) {
        Order order = orderMapper.selectById(id);
        if(Objects.isNull(order)){
            throw new ResourceNotFoundException("order not found");
        }
        List<OrderItem> list = orderItemService.getListByOrderId(id);
        return new OrderDetailView(order,list);
    }

    @Override
    public Order select(Map<String, Object> map){
        return orderMapper.select(map);
    }

    @Override
    public List<Order> selectList(Map<String, Object> map){
        return orderMapper.selectList(map);
    }

    @Override
    public List<Order> selectDistributorList(Integer distributorId) {
        Map<String,Object> map = new HashMap<>();
        map.put("distributorId",distributorId);
        return orderMapper.selectDistributorList(map);
    }

    @Override
    public List<OrderDetailParams> getDetailParamsList(Map<String, Object> map) {
        return orderMapper.selectOrderDetailParamsList(map);
    }

    @Override
    public List<OrderDetailParams> selectOrderDetailParamsViewList(Map<String, Object> map) {
        return orderMapper.selectOrderDetailParamsList(map);
    }

    @Override
    public int selectCount(Map<String, Object> map){
        return orderMapper.selectCount(map);
    }

    @Override
    public int create(Order order){
        return orderMapper.insert(order);
    }

    @Override
    public int update(Order order){
        return orderMapper.update(order);
    }

    @Override
    public int updateStatus(Order order) {
        return orderMapper.updateStatus(order);
    }

    @Override
    public int deleteById(Integer id){
        return orderMapper.deleteById(id);
    }
}