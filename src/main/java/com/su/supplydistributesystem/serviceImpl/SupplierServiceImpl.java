package com.su.supplydistributesystem.serviceImpl;

import com.su.supplydistributesystem.domain.Supplier;
import com.su.supplydistributesystem.service.SupplierService;
import com.su.supplydistributesystem.mapper.SupplierMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public Supplier getById(Integer id){
        return supplierMapper.selectById(id);
    }
    @Override
    public Supplier select(Map<String, Object> map){
        return supplierMapper.select(map);
    }

    @Override
    public List<Supplier> selectList(Map<String, Object> map){
        return supplierMapper.selectList(map);
    }

    @Override
    public int selectCount(Map<String, Object> map){
        return supplierMapper.selectCount(map);
    }

    @Override
    public int create(Supplier supplier){
        return supplierMapper.insert(supplier);
    }

    @Override
    public int update(Supplier supplier){
        return supplierMapper.update(supplier);
    }

    @Override
    public int deleteById(Integer id){
        return supplierMapper.deleteById(id);
    }
}