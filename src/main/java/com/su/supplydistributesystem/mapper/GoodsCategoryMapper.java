package com.su.supplydistributesystem.mapper;

import com.su.supplydistributesystem.domain.GoodsCategory;
import com.su.supplydistributesystem.response.GoodsCategoryListItemView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoodsCategoryMapper {

    GoodsCategory selectById(Integer id);

    GoodsCategory select(Map<String, Object> map);

    List<GoodsCategory> selectList(Map<String, Object> map);

    List<GoodsCategoryListItemView> selectListView(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int insert(GoodsCategory goodsCategory);

    int update(GoodsCategory goodsCategory);

    int deleteById(Integer id);
}