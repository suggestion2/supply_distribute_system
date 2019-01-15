package com.su.supplydistributesystem.serviceImpl;

import com.su.supplydistributesystem.domain.Goods;
import com.su.supplydistributesystem.service.GoodsService;
import com.su.supplydistributesystem.mapper.GoodsMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods getById(Integer id){
        return goodsMapper.selectById(id);
    }
    @Override
    public Goods select(Map<String, Object> map){
        return goodsMapper.select(map);
    }

    @Override
    public List<Goods> selectList(Map<String, Object> map){
        return goodsMapper.selectList(map);
    }

    @Override
    public int selectCount(Map<String, Object> map){
        return goodsMapper.selectCount(map);
    }

    @Override
    public int create(Goods goods){
        return goodsMapper.insert(goods);
    }

    @Override
    public int update(Goods goods){
        return goodsMapper.update(goods);
    }

    @Override
    public int deleteById(Integer id){
        return goodsMapper.deleteById(id);
    }
}