package com.su.supplydistributesystem.mapper;

import com.su.supplydistributesystem.domain.GoodsSupply;
import com.su.supplydistributesystem.request.GoodsSupplyForm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoodsSupplyMapper {

    GoodsSupply selectById(Integer id);

    GoodsSupply select(Map<String, Object> map);

    List<GoodsSupply> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int batchInsert(List<GoodsSupplyForm> list);

    int batchUpdate(GoodsSupplyUpdateParams params);

    int deleteByGoodsId(Integer goodsId);
}