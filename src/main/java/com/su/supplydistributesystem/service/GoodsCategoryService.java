package com.su.supplydistributesystem.service;

import com.su.supplydistributesystem.domain.GoodsCategory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface GoodsCategoryService {
    GoodsCategory getById(Integer id);

    GoodsCategory select(Map<String, Object> map);

    List<GoodsCategory> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int create(GoodsCategory goodsCategory);

    int update(GoodsCategory goodsCategory);

    int deleteById(Integer id);
}