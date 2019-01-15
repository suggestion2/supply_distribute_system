package com.su.supplydistributesystem.serviceImpl;

import com.su.supplydistributesystem.domain.GoodsSuppliy;
import com.su.supplydistributesystem.service.GoodsSuppliyService;
import com.su.supplydistributesystem.mapper.GoodsSuppliyMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsSuppliyServiceImpl implements GoodsSuppliyService{

    @Autowired
    private GoodsSuppliyMapper goodsSuppliyMapper;

    @Override
    public GoodsSuppliy getById(Integer id){
        return goodsSuppliyMapper.selectById(id);
    }
    @Override
    public GoodsSuppliy select(Map<String, Object> map){
        return goodsSuppliyMapper.select(map);
    }

    @Override
    public List<GoodsSuppliy> selectList(Map<String, Object> map){
        return goodsSuppliyMapper.selectList(map);
    }

    @Override
    public int selectCount(Map<String, Object> map){
        return goodsSuppliyMapper.selectCount(map);
    }

    @Override
    public int create(GoodsSuppliy goodsSuppliy){
        return goodsSuppliyMapper.insert(goodsSuppliy);
    }

    @Override
    public int update(GoodsSuppliy goodsSuppliy){
        return goodsSuppliyMapper.update(goodsSuppliy);
    }

    @Override
    public int deleteById(Integer id){
        return goodsSuppliyMapper.deleteById(id);
    }
}