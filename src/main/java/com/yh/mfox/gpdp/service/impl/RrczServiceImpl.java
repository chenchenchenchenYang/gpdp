package com.yh.mfox.gpdp.service.impl;


import com.yh.mfox.gpdp.mapper.RrczMapper;
import com.yh.mfox.gpdp.service.RrczService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RrczServiceImpl implements RrczService {
    @Autowired
    private RrczMapper rrczMapper;

    @Override
    public List<Map<String, Object>> getResidenceAddr() {
        Map<String, Object> gprsMap = new HashMap<>();
        Map<String, Object> extMap = new HashMap<>();
        List<Map<String, Object>> res = new ArrayList<>();
        List<Map<String, Object>> maps = rrczMapper.queryResidenceAddr();
        long gprs = 0;
        long zrs = 0;
        for (Map<String, Object> map : maps) {
            if ("gprs".equals(map.get("NAME"))) {
                gprs = (long) map.get("NUM");
            }
            if ("zrs".equals(map.get("NAME"))) {
                zrs = (long) map.get("NUM");
            }
        }
        BigDecimal bi = new BigDecimal(gprs);
        BigDecimal bj = new BigDecimal(zrs);
        gprsMap.put("NAME", "本地市居民");
        gprsMap.put("NUM",
                ((bi.divide(bj, 4, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100))).setScale(2));
        extMap.put("NAME", "外地是居民");
        extMap.put("NUM", zrs - gprs > 0 ?
                ((new BigDecimal(String.valueOf(bj.subtract(new BigDecimal(gprs)))).divide(bi, 4, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100))).setScale(2) : 0);
        res.add(gprsMap);
        res.add(extMap);
        return res;
    }

    @Override
    public List<Map<String, Object>> getResidence() {
        return rrczMapper.queryResidence();
    }

    @Override
    public Map<String, Object> getCount() {
        Map<String, Object> res = new HashMap<>();
        List<Map<String, Object>> maps = rrczMapper.queryCount();
        long yearRaise = 0;
        long total = 0;
        for (Map<String, Object> map : maps) {
            if ("total".equals(map.get("NAME"))) {
                res.put(map.get("NAME") + "", map.get("NUM"));
                total = (long) map.get("NUM");
            }
            if ("czrs".equals(map.get("NAME"))) {
                res.put(map.get("NAME") + "", map.get("NUM"));
            }
            if ("raise".equals(map.get("NAME"))) {
                yearRaise = (long) map.get("NUM");
                res.put(map.get("NAME") + "", map.get("NUM"));
            }
        }
        if (total != 0) {
            res.put("rate", yearRaise / total);
        } else {
            res.put("rate", 0);
        }
        return res;
    }

    @Override
    public Map<String, Object> getProfess() {
        List<Map<String, Object>> rs = rrczMapper.queryProfessNum();
        List<Map<String, Object>> rank = rrczMapper.queryProfessRate();
        Map<String, Object> res = new HashMap<>();
        res.put("rs", rs);
        res.put("rank", rank);
        return res;
    }

    @Override
    public Map<String, Object> getVocation() {
        List<Map<String, Object>> rs = rrczMapper.queryVocationNum();
        List<Map<String, Object>> rank = rrczMapper.queryVocationRate();
        Map<String, Object> res = new HashMap<>();
        res.put("rs", rs);
        res.put("rank", rank);
        return res;
    }

    @Override
    public Map<String, Object> getCz() {
        Map<String, Object> res = new HashMap<>();
        List<Map<String, Object>> in = rrczMapper.queryCzIn();
        List<Map<String, Object>> bd = rrczMapper.queryCzBd();
        long gprs = 0;
        long zrs = 0;
        for (Map<String, Object> map : bd) {
            if ("gprs".equals(map.get("NAME"))) {
                gprs = (long) map.get("NUM");
            }
            if ("zrs".equals(map.get("NAME"))) {
                zrs = (long) map.get("NUM");
            }
        }
        Map<String, Object> m1 = new HashMap<>();
        Map<String, Object> m2 = new HashMap<>();
        List<Map<String, Object>> bdn = new ArrayList<>();
        m1.put("NAME", "gprs");
        m1.put("NUM", gprs);
        m2.put("NAME","not_gprs");
        m2.put("NUM", zrs - gprs > 0 ? zrs - gprs : 0);
        bdn.add(m1);
        bdn.add(m2);
        List<Map<String, Object>> edu = rrczMapper.queryCzEdu();
        res.put("in",in);
        res.put("bd",bdn);
        res.put("edu",edu);
        return res;
    }
}
