package com.su.supplydistributesystem.service;

import com.su.supplydistributesystem.domain.GoodsSupply;
import com.su.supplydistributesystem.mapper.GoodsSupplyUpdateParams;
import com.su.supplydistributesystem.request.GoodsSupplyForm;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface GoodsSupplyService {
    GoodsSupply getById(Integer id);

    GoodsSupply select(Map<String, Object> map);

    List<GoodsSupply> selectList(Map<String, Object> map);

    List<GoodsSupply> getListByGoodsId(Integer goodsId);

    int selectCount(Map<String, Object> map);

    int batchCreate(List<GoodsSupplyForm> list);

    int batchUpdate(GoodsSupplyUpdateParams params);

    int deleteByGoodsId(Integer goodsId);

}