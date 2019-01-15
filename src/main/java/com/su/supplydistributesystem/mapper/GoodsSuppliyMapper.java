package com.su.supplydistributesystem.mapper;

import com.su.supplydistributesystem.domain.GoodsSuppliy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoodsSuppliyMapper {

    GoodsSuppliy selectById(Integer id);

    GoodsSuppliy select(Map<String, Object> map);

    List<GoodsSuppliy> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int insert(GoodsSuppliy goodsSuppliy);

    int update(GoodsSuppliy goodsSuppliy);

    int deleteById(Integer id);
}