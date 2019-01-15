package com.su.supplydistributesystem.mapper;

import com.su.supplydistributesystem.domain.Supplier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SupplierMapper {

    Supplier selectById(Integer id);

    Supplier select(Map<String, Object> map);

    List<Supplier> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int insert(Supplier supplier);

    int update(Supplier supplier);

    int deleteById(Integer id);
}