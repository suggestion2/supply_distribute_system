package com.su.supplydistributesystem.service;

import com.su.supplydistributesystem.domain.Goods;
import com.su.supplydistributesystem.request.GoodsBatchStatusForm;
import com.su.supplydistributesystem.response.GoodsDetailView;
import com.su.supplydistributesystem.response.GoodsDistributeView;
import com.su.supplydistributesystem.service.GoodsDetailParams;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface GoodsService {
    Goods getById(Integer id);

    Goods getByName(String name);

    GoodsDetailView getDetail(Integer id);

    Goods select(Map<String, Object> map);

    List<Goods> selectList(Map<String, Object> map);

    List<GoodsDistributeView> selectViewList(Map<String, Object> map);

    List<GoodsDetailParams> getDetailParamsList(Map<String, Object> map);

    List<GoodsDetailParams> getAllEnabledList();

    int selectCount(Map<String, Object> map);

    int selectCountByCategoryId(Integer categoryId);

    int create(Goods goods);

    int update(Goods goods);

    int updateStatus(Goods goods);

    int batchUpdateStatus(List<Integer> idList,int status,int updateBy);

    int deleteById(Integer id);
}