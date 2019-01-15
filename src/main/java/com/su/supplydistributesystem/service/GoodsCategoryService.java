package com.su.supplydistributesystem.service;

import com.su.supplydistributesystem.domain.GoodsCategory;
import com.su.supplydistributesystem.response.GoodsCategoryListItemView;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface GoodsCategoryService {
    GoodsCategory getById(Integer id);

    GoodsCategory select(Map<String, Object> map);

    List<GoodsCategory> selectList(Map<String, Object> map);

    List<GoodsCategory> getListByGoodsId(Integer goodsId);

    List<GoodsCategoryListItemView> selectListView(Map<String, Object> map);

    List<GoodsCategoryListItemView> getAllListView();

    List<GoodsCategoryListItemView> getListViewForCreateGoods();

    int selectCount(Map<String, Object> map);

    int create(GoodsCategory goodsCategory);

    int update(GoodsCategory goodsCategory);

    int deleteById(Integer id);
}