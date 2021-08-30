package com.yh.mfox.gpdp.service.impl;

import com.yh.mfox.gpdp.mapper.query.CommenMapper;
import com.yh.mfox.gpdp.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private CommenMapper commenMapper;

    @Override
    public Map<String, Object> getSp(int page, int size, String yj, String ej, String sj) {
        Map<String, Object> params = new HashMap<>();
        params.put("page", (page - 1) * size);
        params.put("size", size);
        params.put("yj", yj);
        params.put("ej", ej);
        params.put("sj", sj);

        Map<String, Object> result = new HashMap<>();
        result.put("page", page);
        result.put("size", size);
        result.put("count", commenMapper.querySpCount(params));
        result.put("rows", commenMapper.querySp(params));
        return result;
    }

    @Override
    public List<Map<String, Object>> getSpType() {
        List<Map<String,Object>> l = new ArrayList<>();
        List<Map<String, Object>> list = commenMapper.querySpType();
        if (list.isEmpty()) return l;
        Map<String, Object> result;
        for (Map<String, Object> map : list) {
            result = new HashMap<>();
            String splx = map.get("SPLX") + "";
            result.put("name",splx);
            result.put("child",commenMapper.queryEjfl(splx));
            l.add(result);
        }
        return l;
    }
}
