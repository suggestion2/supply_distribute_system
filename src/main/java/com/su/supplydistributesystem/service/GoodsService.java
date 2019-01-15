package com.su.supplydistributesystem.service;

import com.su.supplydistributesystem.domain.Goods;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface GoodsService {
    Goods getById(Integer id);

    Goods getByName(String name);

    Goods select(Map<String, Object> map);

    List<Goods> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int selectCountByCategoryId(Integer categoryId);

    int create(Goods goods);

    int update(Goods goods);

    int updateStatus(Goods goods);

    int deleteById(Integer id);
}