package com.yh.mfox.gpdp.service.impl;

import com.yh.mfox.gpdp.mapper.query.EduMapper;
import com.yh.mfox.gpdp.service.EduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EduServiceImpl implements EduService {
    @Autowired
    private EduMapper eduMapper;

    @Override
    public Map<String, Object> getCount() {
        return eduMapper.queryCount();
    }

    @Override
    public List<Map<String, Object>> getXlfb() {
        return eduMapper.queryXlfb();
    }

    @Override
    public List<Map<String, Object>> getByyx() {
        return eduMapper.queryByyx();
    }

    @Override
    public Map<String, Object> getXbbl(String date) {
        List<Map<String, Object>> maps = eduMapper.queryXbbl(date);
        if (null == maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0);
    }

    @Override
    public Map<String, Object> getJszb() {
        return eduMapper.queryJszb();
    }

    @Override
    public Map<String, Object> getType() {
        List<Map<String, Object>> maps = eduMapper.queryType();
        if (null == maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0);
    }

    @Override
    public List<Map<String, Object>> getBase(String type, String name) {
        return eduMapper.queryBase(type,name);
    }

    @Override
    public List<Map<String, Object>> getXsrs(String date) {
        return eduMapper.queryXsrs(date);
    }

    @Override
    public List<Map<String, Object>> getNlfb() {
        return eduMapper.queryNlfb();
    }

    @Override
    public List<Map<String, Object>> getHjsl() {
        return eduMapper.queryHjsl();
    }

    @Override
    public List<Map<String, Object>> getHkszd() {
        return eduMapper.queryHkszd();
    }

    @Override
    public List<Map<String, Object>> getGzjy() {
        return eduMapper.queryGzjy();
    }

    @Override
    public List<Map<String, Object>> getNjfb() {
        return eduMapper.queryNjfb();
    }

    @Override
    public List<Map<String, Object>> getHjtj() {
        return eduMapper.queryHjtj();
    }

    @Override
    public List<Map<String, Object>> getZxxstj() {
        return eduMapper.queryZxxstj();
    }

    @Override
    public List<Map<String, Object>> getSsqk() {
        return eduMapper.querySsqk();
    }

    @Override
    public List<Map<String, Object>> getXszb() {
        return eduMapper.queryXszb();
    }
}
