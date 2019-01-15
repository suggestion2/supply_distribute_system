package com.su.supplydistributesystem.service;

import com.su.supplydistributesystem.domain.GoodsSuppliy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface GoodsSuppliyService {
    GoodsSuppliy getById(Integer id);

    GoodsSuppliy select(Map<String, Object> map);

    List<GoodsSuppliy> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int create(GoodsSuppliy goodsSuppliy);

    int update(GoodsSuppliy goodsSuppliy);

    int deleteById(Integer id);
}