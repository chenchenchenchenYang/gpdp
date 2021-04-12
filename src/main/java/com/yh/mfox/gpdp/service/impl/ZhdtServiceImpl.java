package com.yh.mfox.gpdp.service.impl;

import com.yh.mfox.gpdp.mapper.ZhtdMapper;
import com.yh.mfox.gpdp.service.ZhdtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZhdtServiceImpl implements ZhdtService {

    @Autowired
    private ZhtdMapper zhtdMapper;

    @Override
    public Map<String, Object> getDtgl() {
        List<Map<String, Object>> result =  zhtdMapper.queryDtgl();
        if(null == result || result.isEmpty()) return new HashMap<>();
        return result.get(0);
    }

    @Override
    public List<Map<String, Object>> getSceneCount() {
        return zhtdMapper.querySceneCount();
    }

    @Override
    public List<Map<String, Object>> getDtCount() {
        return zhtdMapper.queryDtCount();
    }

    @Override
    public List<Map<String, Object>> getDtType() {
        return zhtdMapper.queryDtType();
    }

    @Override
    public List<Map<String, Object>> getWbCount() {
        return zhtdMapper.queryWbCount();
    }

    @Override
    public List<Map<String, Object>> getDtAvg() {
        return zhtdMapper.queryDtAvg();
    }

    @Override
    public List<Map<String, Object>> getMonthAvg() {
        return zhtdMapper.queryMonthAvg();
    }

    @Override
    public List<Map<String, Object>> getWbTotal() {
        return zhtdMapper.queryWbTotal();
    }
}
