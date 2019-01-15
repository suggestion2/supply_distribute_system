package com.su.supplydistributesystem.serviceImpl;

import com.su.supplydistributesystem.domain.GoodsSupply;
import com.su.supplydistributesystem.service.GoodsSupplyService;
import com.su.supplydistributesystem.mapper.GoodsSupplyMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsSupplyServiceImpl implements GoodsSupplyService{

    @Autowired
    private GoodsSupplyMapper goodsSupplyMapper;

    @Override
    public GoodsSupply getById(Integer id){
        return goodsSupplyMapper.selectById(id);
    }
    @Override
    public GoodsSupply select(Map<String, Object> map){
        return goodsSupplyMapper.select(map);
    }

    @Override
    public List<GoodsSupply> selectList(Map<String, Object> map){
        return goodsSupplyMapper.selectList(map);
    }

    @Override
    public int selectCount(Map<String, Object> map){
        return goodsSupplyMapper.selectCount(map);
    }

    @Override
    public int create(GoodsSupply goodsSupply){
        return goodsSupplyMapper.insert(goodsSupply);
    }

    @Override
    public int update(GoodsSupply goodsSupply){
        return goodsSupplyMapper.update(goodsSupply);
    }

    @Override
    public int deleteById(Integer id){
        return goodsSupplyMapper.deleteById(id);
    }
}