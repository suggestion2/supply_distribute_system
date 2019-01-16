package com.su.supplydistributesystem.service;

import com.su.supplydistributesystem.domain.Supplier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface SupplierService {
    Supplier getById(Integer id);

    Supplier getByName(String name);

    Supplier select(Map<String, Object> map);

    List<Supplier> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int create(Supplier supplier);

    int update(Supplier supplier);

    int deleteById(Integer id);
}