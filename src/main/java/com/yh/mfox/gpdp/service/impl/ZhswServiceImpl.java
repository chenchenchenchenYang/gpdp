package com.yh.mfox.gpdp.service.impl;

import com.yh.mfox.gpdp.mapper.ZhswMapper;
import com.yh.mfox.gpdp.service.ZhswService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZhswServiceImpl implements ZhswService {

    @Autowired
    private ZhswMapper zhswMapper;

    @Override
    public List<Map<String, Object>> getYsl(String year) {
        return zhswMapper.queryYsl(year);
    }

    @Override
    public Map<String, Object> getGgqk() {
        List<Map<String, Object>> maps = zhswMapper.queryGgqk();
        if(null == maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0) ;
    }

    @Override
    public Map<String, Object> getZlmj(String year) {
        List<Map<String, Object>> maps = zhswMapper.queryZlmj(year);
        if(null == maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0) ;
    }

    @Override
    public Map<String, Object> getYsgc(String year) {
        List<Map<String, Object>> maps = zhswMapper.queryYsgc(year);
        if(null == maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0) ;
    }

    @Override
    public Map<String, Object> getZlssy(String year) {
        List<Map<String, Object>> maps = zhswMapper.queryZlssy(year);
        if(null == maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0) ;
    }

    @Override
    public List<Map<String, Object>> getHlInfo(String name) {
        return zhswMapper.queryHlInfo(name);
    }

    @Override
    public List<Map<String, Object>> getSkInfp(String name) {
        return zhswMapper.querySkInfp(name);
    }

    @Override
    public List<Map<String, Object>> getXqjyl() {
        return zhswMapper.queryXqjyl();
    }
}
