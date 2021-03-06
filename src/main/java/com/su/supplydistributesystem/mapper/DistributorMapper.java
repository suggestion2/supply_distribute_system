package com.su.supplydistributesystem.mapper;

import com.su.supplydistributesystem.domain.Distributor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DistributorMapper {

    Distributor selectById(Integer id);

    Distributor selectByAccount(Map<String,Object> map);

    List<Distributor> selectByNameOrAccount(Map<String, Object> map);

    Distributor select(Map<String, Object> map);

    List<Distributor> selectList(Map<String, Object> map);

    int selectCount(Map<String, Object> map);

    int insert(Distributor distributor);

    int update(Distributor distributor);

    int updatePassword(Distributor distributor);

    int deleteById(Integer id);
}