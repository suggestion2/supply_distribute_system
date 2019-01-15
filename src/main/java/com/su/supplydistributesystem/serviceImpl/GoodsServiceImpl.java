package com.su.supplydistributesystem.serviceImpl;

import com.su.supplydistributesystem.domain.Goods;
import com.su.supplydistributesystem.service.GoodsService;
import com.su.supplydistributesystem.mapper.GoodsMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.su.supplydistributesystem.constants.GoodsConstants.ENABLE;

@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods getById(Integer id){
        return goodsMapper.selectById(id);
    }

    @Override
    public Goods getByName(String name) {
        return this.select(Collections.singletonMap("name",name));
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
    public int selectCountByCategoryId(Integer categoryId) {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryId",categoryId);
        map.put("status",ENABLE);
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
    public int updateStatus(Goods goods) {
        return goodsMapper.updateStatus(goods);
    }

    @Override
    public int deleteById(Integer id){
        return goodsMapper.deleteById(id);
    }
}