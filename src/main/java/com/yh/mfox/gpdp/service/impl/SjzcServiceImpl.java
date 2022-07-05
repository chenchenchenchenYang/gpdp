package com.yh.mfox.gpdp.service.impl;

import com.yh.mfox.gpdp.mapper.query.SjzcMapper;
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
        return maps.get(0);
    }

    @Override
    public Map<String, Object> getJrpm() {
        List<Map<String, Object>> jrzl = sjzcMapper.queryJrzl();
        //List<Map<String, Object>> rzl = sjzcMapper.queryRzl();
        //List<Map<String, Object>> qb = sjzcMapper.queryQb();
        Map<String, Object> result = new HashMap<>();
        result.put("jrzl", jrzl);
        //result.put("rzl", rzl);
        //result.put("qb", qb);
        return result;
    }

    @Override
    public Map<String, Object> getJrpc() {
        List<Map<String, Object>> kbsl = sjzcMapper.queryKbsl();
        //List<Map<String, Object>> spsl = sjzcMapper.querySpsl();
        //List<Map<String, Object>> qb = sjzcMapper.queryQbpc();
        Map<String, Object> result = new HashMap<>();
        result.put("kbsl", kbsl);
        //result.put("spsl", spsl);
        //result.put("qb", qb);
        return result;
    }

    @Override
    public Map<String, Object> getExchange() {
        List<Map<String, Object>> maps = sjzcMapper.queryExchange();
        if (null == maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0);
    }

    @Override
    public Map<String, Object> getSjzl() {
        List<Map<String, Object>> maps = sjzcMapper.querySjzl();
        if (null == maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0);
    }

    @Override
    public List<Map<String, Object>> getXlpm() {
        return sjzcMapper.queryXlpmLx();
    }

    @Override
    public Map<String, Object> getZtzy() {
        return sjzcMapper.queryZtzy().get(0);
    }

    @Override
    public List<Map<String, Object>> getBmsx() {
        return sjzcMapper.queryBmsx();
    }
}
