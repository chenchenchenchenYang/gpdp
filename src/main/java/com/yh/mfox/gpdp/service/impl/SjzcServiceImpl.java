package com.yh.mfox.gpdp.service.impl;

import com.yh.mfox.gpdp.mapper.SjzcMapper;
import com.yh.mfox.gpdp.service.SjzcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SjzcServiceImpl implements SjzcService {
    @Autowired
    private SjzcMapper sjzcMapper;
    @Override
    public Map<String, Object> getCount() {
        List<Map<String, Object>> maps = sjzcMapper.queryCount();
        if(null == maps ||maps.isEmpty()) return new HashMap<>();
        return maps.get(0);
    }

    @Override
    public Map<String, Object> getJrpm() {
        List<Map<String, Object>> jrzl = sjzcMapper.queryJrzl();
        List<Map<String, Object>> rzl = sjzcMapper.queryRzl();
        List<Map<String, Object>> qb = sjzcMapper.queryQb();
        Map<String,Object> result =  new HashMap<>();
        result.put("jrzl",jrzl);
        result.put("rzl",rzl);
        result.put("qb",qb);
        return result;
    }

    @Override
    public Map<String, Object> getJrpc() {
        List<Map<String, Object>> kbsl = sjzcMapper.queryKbsl();
        List<Map<String, Object>> spsl = sjzcMapper.querySpsl();
        List<Map<String, Object>> qb = sjzcMapper.queryQbpc();
        Map<String,Object> result =  new HashMap<>();
        result.put("kbsl",kbsl);
        result.put("spsl",spsl);
        result.put("qb",qb);
        return result;
    }

    @Override
    public Map<String, Object> getExchange() {
        List<Map<String, Object>> maps = sjzcMapper.queryExchange();
        if(null == maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0);
    }

    @Override
    public Map<String, Object> getSjzl() {
        List<Map<String, Object>> maps = sjzcMapper.querySjzl();
        if(null == maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0);
    }

    @Override
    public Map<String, Object> getXlpm() {
        List<Map<String, Object>> lx = sjzcMapper.queryXlpmLx();
        // List<Map<String, Object>> ss = sjzcMapper.queryXlpmSs();
        // List<Map<String, Object>> qb = sjzcMapper.queryXlpmQb();
        List<Map<String, Object>> wts = sjzcMapper.queryWts();
        Map<String,Object> result =  new HashMap<>();
        result.put("lx",lx);
        // result.put("ss",ss);
        // result.put("qb",qb);
        result.put("wts",wts);
        return result;
    }
}
