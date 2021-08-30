package com.yh.mfox.gpdp.service.impl;

import com.yh.mfox.gpdp.mapper.query.ZhswMapper;
import com.yh.mfox.gpdp.service.ZhswService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        if (null == maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0);
    }

    @Override
    public Map<String, Object> getZlmj(String year) {
        List<Map<String, Object>> maps = zhswMapper.queryZlmj(year);
        if (null == maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0);
    }

    @Override
    public Map<String, Object> getYsgc(String year) {
        List<Map<String, Object>> maps = zhswMapper.queryYsgc(year);
        if (null == maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0);
    }

    @Override
    public Map<String, Object> getZlssy(String year) {
        List<Map<String, Object>> maps = zhswMapper.queryZlssy(year);
        if (null == maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0);
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

    @Override
    public List<Map<String, Object>> getDmjc() {
        // 先查每个断面最新年份
        List<Map<String, Object>> yearList = zhswMapper.queryDmYear();
        if (yearList.isEmpty()) return new ArrayList<>();
        List<Map<String, Object>> count = new ArrayList<>();
        for (Map<String, Object> map : yearList) {
            List<Map<String, Object>> c = zhswMapper.queryDmCount(map.get("name") + "", map.get("year") + "");
            count.addAll(c);
        }
        // 便利通过
        return count;
    }

    @Override
    public Map<String, Object> getDmdetail(int page,int size) {
        Map<String, Object> result = new HashMap<>();
        result.put("page", page);
        result.put("size", size);
        result.put("count", zhswMapper.queryCount());
        result.put("rows", zhswMapper.queryDmdetail((page - 1) * size,size));
        return result;
    }
}
