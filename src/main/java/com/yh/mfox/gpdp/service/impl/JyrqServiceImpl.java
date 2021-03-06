package com.yh.mfox.gpdp.service.impl;

import com.yh.mfox.gpdp.mapper.query.JyrqMapper;
import com.yh.mfox.gpdp.service.JyrqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JyrqServiceImpl implements JyrqService {

    @Autowired
    private JyrqMapper jyrqMapper;
    @Override
    public List<Map<String, Object>> getInfoCount() {
        return jyrqMapper.queryInfoCount();
    }

    @Override
    public List<Map<String, Object>> getTypeInfo() {
        return jyrqMapper.queryTypeInfo();
    }

    @Override
    public List<Map<String, Object>> getSexInfo() {
        List<Map<String, Object>> sex = jyrqMapper.querySexInfo();
        if(null == sex || sex.isEmpty()) sex = jyrqMapper.querySexInfoBak();
        return sex;
    }

    @Override
    public List<Map<String, Object>> getLwscInfo() {
        return jyrqMapper.queryLwscInfo();
    }

    @Override
    public List<Map<String, Object>> getCount() {
        return jyrqMapper.queryCount();
    }

    @Override
    public List<Map<String, Object>> getEduCount() {
        return jyrqMapper.queryEduCount();
    }

    @Override
    public List<Map<String, Object>> getAgeCount() {
        return jyrqMapper.queryAgeCount();
    }

    @Override
    public List<Map<String, Object>> getJyType() {
        return jyrqMapper.queryJyType();
    }

    @Override
    public List<Map<String, Object>> getZzType() {
        return jyrqMapper.queryZzType();
    }

    @Override
    public List<Map<String, Object>> getJyfx() {
        return jyrqMapper.queryJyfx();
    }

    @Override
    public List<Map<String, Object>> getXytType() {
        return jyrqMapper.queryXytType();
    }

    @Override
    public List<Map<String, Object>> getLhType() {
        return jyrqMapper.queryLhType();
    }
}
