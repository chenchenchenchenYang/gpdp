package com.yh.mfox.gpdp.service.impl;

import com.yh.mfox.gpdp.mapper.PxqzMapper;
import com.yh.mfox.gpdp.service.PxqzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PxqzServiceImpl implements PxqzService {
    @Autowired
    private PxqzMapper pxqzMapper;

    @Override
    public List<Map<String, Object>> getCount() {
        return pxqzMapper.queryCount();
    }

    @Override
    public Map<String, Object> getRyInfo() {
        Map<String, Object> res = new HashMap<>();
        Map<String, Object> pxMap = new HashMap<>();
        Map<String, Object> qzMap = new HashMap<>();
        // 培训
        pxMap.put("data", pxqzMapper.queryRyPx());
        pxMap.put("total", pxqzMapper.queryRyPxTotal().get(0).get("NUM"));
        qzMap.put("data", pxqzMapper.queryRyQz());
        qzMap.put("total", pxqzMapper.queryRyQZTotal().get(0).get("NUM"));
        res.put("px", pxMap);
        res.put("qz", qzMap);
        return res;
    }

    @Override
    public List<Map<String, Object>> getGzCount() {
        return pxqzMapper.queryRyPx();
    }

    @Override
    public List<Map<String, Object>> getXbCount() {
        List<Map<String, Object>> xb = pxqzMapper.queryXbCount();
        if (xb == null || xb.isEmpty()) xb = pxqzMapper.queryXbCountBak();
        return xb;
    }

    @Override
    public Map<String, Object> getPxInfo() {
        Map<String,Object> res = new HashMap<>();
        // 统计
        List<Map<String, Object>> count = pxqzMapper.queryPxCount();
        Map<String,Object> rate = new HashMap<>();
        BigDecimal rs = new BigDecimal(0);
        BigDecimal real = new BigDecimal(0);
        if (null != count && count.size() > 0) {
            for (Map<String, Object> map : count) {
                if ("rs".equals(map.get("NAME"))) {
                    rs = new BigDecimal((Long) map.get("NUM"));
                }
                if ("real_rs".equals(map.get("NAME"))) {
                    real = new BigDecimal((Long) map.get("NUM"));
                }
            }
            if (rs.equals(BigDecimal.ZERO) || real.equals(BigDecimal.ZERO)){
                rate.put("rate",0);
            }else {
                rate.put("rate", ((real.divide(rs,4,BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100))).setScale(2));
            };
            count.add(rate);
        }
        res.put("count",count);
        // 学历分析
        res.put("edu",pxqzMapper.queryPxEduCount());
        // 年龄段分析
        res.put("age",pxqzMapper.queryPxAgeCount());
        return res;
    }

    @Override
    public Map<String, Object> getQzInfo() {
        Map<String,Object> res = new HashMap<>();
        // 统计
        List<Map<String, Object>> count = pxqzMapper.queryQzCount();
        Map<String,Object> rate = new HashMap<>();
        BigDecimal qz = new BigDecimal(0);
        BigDecimal dwqz = new BigDecimal(0);
        if (null != count && count.size() > 0) {
            for (Map<String, Object> map : count) {
                if ("qz".equals(map.get("NAME"))) {
                    qz = new BigDecimal((Long) map.get("NUM"));
                }
                if ("dw".equals(map.get("NAME"))) {
                    dwqz = new BigDecimal((Long) map.get("NUM"));
                }
            }
            if (qz.equals(BigDecimal.ZERO) || dwqz.equals(BigDecimal.ZERO)){
                rate.put("rate",0);
            }else {
                rate.put("rate", ((dwqz.divide(qz,4,BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100))).setScale(2));
            };
            count.add(rate);
        }
        res.put("count",count);
        // 行业
        res.put("hy",pxqzMapper.queryRyQz());
        // 期望薪资
        res.put("xz",pxqzMapper.queryQzXz());
        return res;
    }

    @Override
    public Map<String, Object> getRyInfoNew() {
        Map<String, Object> pxMap = new HashMap<>();
        pxMap.put("type", pxqzMapper.queryPxType().get(0).get("NUM")); // 类型数量
        pxMap.put("total", pxqzMapper.queryPxTotal().get(0).get("NUM")); // 总人数
        pxMap.put("typeInfo", pxqzMapper.queryPxTypeInfo()); // 类型详情
        pxMap.put("jyType", pxqzMapper.queryPxRyJyType()); // 就业类型统计
        return pxMap;
    }

    @Override
    public Map<String, Object> getQzInfoNew() {
        Map<String, Object> qzMap = new HashMap<>();
        qzMap.put("type", pxqzMapper.queryQzType().get(0).get("NUM")); // 类型数量
        qzMap.put("total", pxqzMapper.queryQzTotal().get(0).get("NUM")); // 总人数
        qzMap.put("typeInfo", pxqzMapper.queryQzTypeInfo()); // 类型详情
        qzMap.put("jyType", pxqzMapper.queryQzRyJyType()); // 就业类型统计
        return qzMap;
    }

    @Override
    public List<Map<String, Object>> getDyyx() {
        return pxqzMapper.queryDyyx();
    }

    @Override
    public List<Map<String, Object>> getSexInfo(String type) {
        return pxqzMapper.querySexInfo(type);
    }
}
