package com.su.supplydistributesystem.service;

import com.su.supplydistributesystem.domain.GoodsSupply;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface GoodsSupplyService {
    GoodsSupply getById(Integer id);

    GoodsSupply select(Map<String, Object> map);

    List<GoodsSupply> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int create(GoodsSupply goodsSupply);

    int update(GoodsSupply goodsSupply);

    int deleteById(Integer id);
}