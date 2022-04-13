package com.yh.mfox.gpdp.service.impl;

import com.yh.mfox.gpdp.mapper.query.ZhlyMapper;
import com.yh.mfox.gpdp.service.ZhlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ZhlyServiceImpl implements ZhlyService {
    @Autowired
    private ZhlyMapper zhlyMapper;

    @Override
    public Map<String, Object> getCount() {
        return zhlyMapper.queryCount();
    }

    @Override
    public List<Map<String, Object>> getHxdjzb() {
        return zhlyMapper.queryHxdjzb();
    }

    @Override
    public Map<String, Object> getDyx() {
        return zhlyMapper.queryDyx();
    }

    @Override
    public Map<String, Object> getFhwz() {
        return zhlyMapper.queryFhwz();
    }

    @Override
    public List<Map<String, Object>> getHly(String name) {
        return zhlyMapper.queryHly(name);
    }

    @Override
    public List<Map<String, Object>> getZfdw(String dwmc) {
        return zhlyMapper.queryZfdw(dwmc);
    }

    @Override
    public List<Map<String, Object>> getZbxq(String dwmc,String zbmc) {
        return zhlyMapper.queryZbxq(dwmc,zbmc);
    }

    @Override
    public List<Map<String, Object>> getJbxx(String lcmc) {
        return zhlyMapper.queryJbxx(lcmc);
    }

    @Override
    public Map<String, Object> getSlfgl() {
        return zhlyMapper.querySlfgl();
    }

    @Override
    public List<Map<String, Object>> getGylxx() {
        return zhlyMapper.queryGylxx();
    }
}
