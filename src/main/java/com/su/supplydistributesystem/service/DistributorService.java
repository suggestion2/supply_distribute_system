package com.su.supplydistributesystem.service;

import com.su.supplydistributesystem.domain.Distributor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface DistributorService {
    Distributor getById(Integer id);

    Distributor select(Map<String, Object> map);

    List<Distributor> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int create(Distributor distributor);

    int update(Distributor distributor);

    int deleteById(Integer id);
}