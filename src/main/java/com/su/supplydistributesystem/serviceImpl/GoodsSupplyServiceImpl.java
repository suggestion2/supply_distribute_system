package com.su.supplydistributesystem.serviceImpl;

import com.su.supplydistributesystem.domain.GoodsSupply;
import com.su.supplydistributesystem.mapper.GoodsSupplyUpdateParams;
import com.su.supplydistributesystem.request.GoodsSupplyForm;
import com.su.supplydistributesystem.service.GoodsSupplyService;
import com.su.supplydistributesystem.mapper.GoodsSupplyMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsSupplyServiceImpl implements GoodsSupplyService{

    @Autowired
    private GoodsSupplyMapper goodsSupplyMapper;

    @Override
    public GoodsSupply getById(Integer id){
        return goodsSupplyMapper.selectById(id);
    }
    @Override
    public GoodsSupply select(Map<String, Object> map){
        return goodsSupplyMapper.select(map);
    }

    @Override
    public List<GoodsSupply> selectList(Map<String, Object> map){
        return goodsSupplyMapper.selectList(map);
    }

    @Override
    public List<GoodsSupply> getListByGoodsId(Integer goodsId) {
        return this.selectList(Collections.singletonMap("goodsId",goodsId));
    }

    @Override
    public int selectCount(Map<String, Object> map){
        return goodsSupplyMapper.selectCount(map);
    }

    @Override
    public int batchCreate(List<GoodsSupplyForm> list) {
        return goodsSupplyMapper.batchInsert(list);
    }

    @Override
    public int batchUpdate(GoodsSupplyUpdateParams params) {
        return goodsSupplyMapper.batchUpdate(params);
    }

    @Override
    public int deleteByGoodsId(Integer goodsId) {
        return goodsSupplyMapper.deleteByGoodsId(goodsId);
    }
}