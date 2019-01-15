package com.su.supplydistributesystem.serviceImpl;

import com.su.supplydistributesystem.domain.GoodsCategory;
import com.su.supplydistributesystem.service.GoodsCategoryService;
import com.su.supplydistributesystem.mapper.GoodsCategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService{

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public GoodsCategory getById(Integer id){
        return goodsCategoryMapper.selectById(id);
    }
    @Override
    public GoodsCategory select(Map<String, Object> map){
        return goodsCategoryMapper.select(map);
    }

    @Override
    public List<GoodsCategory> selectList(Map<String, Object> map){
        return goodsCategoryMapper.selectList(map);
    }

    @Override
    public int selectCount(Map<String, Object> map){
        return goodsCategoryMapper.selectCount(map);
    }

    @Override
    public int create(GoodsCategory goodsCategory){
        return goodsCategoryMapper.insert(goodsCategory);
    }

    @Override
    public int update(GoodsCategory goodsCategory){
        return goodsCategoryMapper.update(goodsCategory);
    }

    @Override
    public int deleteById(Integer id){
        return goodsCategoryMapper.deleteById(id);
    }
}