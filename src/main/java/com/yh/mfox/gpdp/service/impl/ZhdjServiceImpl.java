package com.yh.mfox.gpdp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yh.mfox.gpdp.mapper.ZhdjMapper;
import com.yh.mfox.gpdp.service.ZhdjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ZhdjServiceImpl implements ZhdjService {
    @Autowired
    ZhdjMapper zhdjMapper;

    @Override
    public List<Map<String, Object>> getDljgAll() {
        return zhdjMapper.queryDljgAll();
    }

    @Override
    public JSONObject getDjfcByType() {
        JSONObject json = new JSONObject();
        json.put("banner", zhdjMapper.queryDjfcByType("banner"));
        json.put("image", zhdjMapper.queryDjfcByType("image"));
        return json;
    }

    @Override
    public List<Map<String, Object>> getDyxl() {
        return zhdjMapper.queryDyxl();
    }

    @Override
    public List<Map<String, Object>> getDyxb() {
        return zhdjMapper.queryDyxb();
    }

    @Override
    public List<Map<String, Object>> getDyhy() {
        return zhdjMapper.queryDyhy();
    }

    @Override
    public List<Map<String,Object>> getDyjbqk() {
        return zhdjMapper.queryDyjbqk();
    }

    @Override
    public List<Map<String, Object>> getDyfc() {
        return zhdjMapper.queryDyfc();
    }

    @Override
    public List<Map<String, Object>> getDdmf() {
        return zhdjMapper.queryDdmf();
    }

    @Override
    public List<Map<String, Object>> getDynljg() {
        return zhdjMapper.queryDynljg();
    }

    @Override
    public List<Map<String, Object>> getFzdyqk() {
        return zhdjMapper.queryFzdyqk();
    }

    @Override
    public List<Map<String, Object>> getZzxfb() {
        return zhdjMapper.queryZzxfb();
    }

    @Override
    public List<Map<String, Object>> getRmgjc() {
        return zhdjMapper.queryRmgjc();
    }

    @Override
    public List<Map<String, Object>> getShyk() {
        return zhdjMapper.queryShyk();
    }

    @Override
    public List<Map<String, Object>> getZyzhd() {
        return zhdjMapper.queryZyzhd();
    }
}
