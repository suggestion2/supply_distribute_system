package com.su.supplydistributesystem.mapper;

import com.su.supplydistributesystem.domain.GoodsSupply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoodsSupplyMapper {

    GoodsSupply selectById(Integer id);

    GoodsSupply select(Map<String, Object> map);

    List<GoodsSupply> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int insert(GoodsSupply goodsSupply);

    int update(GoodsSupply goodsSupply);

    int deleteById(Integer id);
}