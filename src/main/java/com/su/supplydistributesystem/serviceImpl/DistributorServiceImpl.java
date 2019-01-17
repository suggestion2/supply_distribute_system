package com.su.supplydistributesystem.serviceImpl;

import com.su.supplydistributesystem.domain.Distributor;
import com.su.supplydistributesystem.request.DistributorCreateForm;
import com.su.supplydistributesystem.service.DistributorService;
import com.su.supplydistributesystem.mapper.DistributorMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.su.supplydistributesystem.constants.DistributorConstants.ENABLE;

@Service
public class DistributorServiceImpl implements DistributorService{

    @Autowired
    private DistributorMapper distributorMapper;

    @Override
    public Distributor getById(Integer id){
        return distributorMapper.selectById(id);
    }

    @Override
    public Distributor getByAccount(String account) {
        Map<String,Object> query = new HashMap<>();
        query.put("account",account);
        return distributorMapper.selectByAccount(query);
    }

    @Override
    public List<Distributor> getByNameOrAccount(Map<String, Object> map) {
        return distributorMapper.selectByNameOrAccount(map);
    }

    @Override
    public Distributor select(Map<String, Object> map){
        return distributorMapper.select(map);
    }

    @Override
    public List<Distributor> selectList(Map<String, Object> map){
        return distributorMapper.selectList(map);
    }

    @Override
    public List<Distributor> getAllEnabledList() {
        return distributorMapper.selectList(Collections.singletonMap("status",ENABLE));
    }

    @Override
    public int selectCount(Map<String, Object> map){
        return distributorMapper.selectCount(map);
    }

    @Override
    public int create(Distributor distributor){
        return distributorMapper.insert(distributor);
    }

    @Override
    public int update(Distributor distributor){
        return distributorMapper.update(distributor);
    }

    @Override
    public int updatePassword(Distributor distributor) {
        return distributorMapper.updatePassword(distributor);
    }

    @Override
    public int deleteById(Integer id){
        return distributorMapper.deleteById(id);
    }
}