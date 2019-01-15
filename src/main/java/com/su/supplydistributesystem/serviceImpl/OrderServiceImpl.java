package com.su.supplydistributesystem.serviceImpl;

import com.su.supplydistributesystem.domain.Order;
import com.su.supplydistributesystem.service.OrderService;
import com.su.supplydistributesystem.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order getById(Integer id){
        return orderMapper.selectById(id);
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
    public int deleteById(Integer id){
        return orderMapper.deleteById(id);
    }
}