package com.yh.mfox.gpdp.service.impl;

import com.yh.mfox.gpdp.mapper.JyrqMapper;
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
}