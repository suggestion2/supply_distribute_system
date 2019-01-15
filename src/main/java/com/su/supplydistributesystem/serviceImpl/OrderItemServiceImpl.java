package com.su.supplydistributesystem.serviceImpl;

import com.su.supplydistributesystem.domain.OrderItem;
import com.su.supplydistributesystem.service.OrderItemService;
import com.su.supplydistributesystem.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public OrderItem getById(Integer id){
        return orderItemMapper.selectById(id);
    }
    @Override
    public OrderItem select(Map<String, Object> map){
        return orderItemMapper.select(map);
    }

    @Override
    public List<OrderItem> selectList(Map<String, Object> map){
        return orderItemMapper.selectList(map);
    }

    @Override
    public int selectCount(Map<String, Object> map){
        return orderItemMapper.selectCount(map);
    }

    @Override
    public int create(OrderItem orderItem){
        return orderItemMapper.insert(orderItem);
    }

    @Override
    public int update(OrderItem orderItem){
        return orderItemMapper.update(orderItem);
    }

    @Override
    public int deleteById(Integer id){
        return orderItemMapper.deleteById(id);
    }
}