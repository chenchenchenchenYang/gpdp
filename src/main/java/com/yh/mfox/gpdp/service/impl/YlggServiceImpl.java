package com.yh.mfox.gpdp.service.impl;

import com.yh.mfox.gpdp.mapper.YlggMapper;
import com.yh.mfox.gpdp.service.YlggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class YlggServiceImpl implements YlggService {

    @Autowired
    private YlggMapper ylggMapper;

    @Override
    public Map<String, Object> getRsCount(String type, String date) {
        List<Map<String, Object>> maps = ylggMapper.queryRsCount(type, date);
        if (null == maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0);
    }

    @Override
    public Map<String, Object> getSrCount(String type, String date) {
        Map<String,Object> res = new HashMap<>();
        List<Map<String, Object>> mzCount = ylggMapper.queryMzCount(type, date);
        List<Map<String, Object>> zyCount = ylggMapper.queryZyCount(type, date);
        if (null == mzCount || mzCount.isEmpty()){
            res.put("mz",new HashMap<>());
        }else {
            Map<String, Object> map = mzCount.get(0);
            BigDecimal mzyzb = new BigDecimal(map.get("MZYZB") + "");
            if("year".equals(type)){
                BigDecimal mz = mzyzb.divide(new BigDecimal(365), 2, BigDecimal.ROUND_HALF_DOWN);
                map.put("MZYZB",mz);
                map.put("OTHER",new BigDecimal("100").subtract(mz));
            }else if("month".equals(type)){
                BigDecimal mz = mzyzb.divide(new BigDecimal(30), 2, BigDecimal.ROUND_HALF_DOWN);
                map.put("MZYZB",mz);
                map.put("OTHER",new BigDecimal("100").subtract(mz));
            }else if("week".equals(type)){
                BigDecimal mz = mzyzb.divide(new BigDecimal(7), 2, BigDecimal.ROUND_HALF_DOWN);
                map.put("MZYZB",mz);
                map.put("OTHER",new BigDecimal("100").subtract(mz));
            }else if("day".equals(type)){
                BigDecimal mz = mzyzb.setScale(2, BigDecimal.ROUND_HALF_DOWN);
                map.put("MZYZB",mz);
                map.put("OTHER",new BigDecimal("100").subtract(mz));
            }
            res.put("mz",map);
        }

        if (null == zyCount || zyCount.isEmpty()){
            res.put("zy",new HashMap<>());
        }else {
            Map<String, Object> map = zyCount.get(0);
            BigDecimal zyyzb = new BigDecimal(map.get("ZYYZB") + "");
            if("year".equals(type)){
                BigDecimal mz = zyyzb.divide(new BigDecimal(365), 2, BigDecimal.ROUND_HALF_DOWN);
                map.put("ZYYZB",mz);
                map.put("OTHER",new BigDecimal("100").subtract(mz));
            }else if("month".equals(type)){
                BigDecimal mz = zyyzb.divide(new BigDecimal(30), 2, BigDecimal.ROUND_HALF_DOWN);
                map.put("ZYYZB",mz);
                map.put("OTHER",new BigDecimal("100").subtract(mz));
            }else if("week".equals(type)){
                BigDecimal mz = zyyzb.divide(new BigDecimal(7), 2, BigDecimal.ROUND_HALF_DOWN);
                map.put("ZYYZB",mz);
                map.put("OTHER",new BigDecimal("100").subtract(mz));
            }else if("day".equals(type)){
                BigDecimal zy = zyyzb.setScale(2, BigDecimal.ROUND_HALF_DOWN);
                map.put("ZYYZB",zy);
                map.put("OTHER",new BigDecimal("100").subtract(zy));
            }
            res.put("zy",map);
        }
        return res;
    }

    @Override
    public List<Map<String, Object>> getSsjc(String type, String date) {
        if(!"".equals(type) && "day".equals(type)) return ylggMapper.querySsjcDay(date);
        else if("week".equals(type)) return ylggMapper.querySsjcWeek(date);
        else if("month".equals(type)) return ylggMapper.querySsjcMonth(date);
        else if("year".equals(type)) return ylggMapper.querySsjcYear(date);
        return new ArrayList<>();
    }

    @Override
    public List<Map<String, Object>> getRyrs(String type, String date) {
        if(!"".equals(type) && "day".equals(type)) return ylggMapper.queryRyrsDay(date);
        else if("week".equals(type)) return ylggMapper.queryRyrsWeek(date);
        else if("month".equals(type)) return ylggMapper.queryRyrsMonth(date);
        else if("year".equals(type)) return ylggMapper.queryRyrsYear(date);
        return new ArrayList<>();
    }

    @Override
    public List<Map<String, Object>> getJcf(String type, String date) {
        if(!"".equals(type) && "day".equals(type)) return ylggMapper.queryJcfDay(date);
        else if("week".equals(type)) return ylggMapper.queryJcfWeek(date);
        else if("month".equals(type)) return ylggMapper.queryJcfMonth(date);
        else if("year".equals(type)) return ylggMapper.queryJcfYear(date);
        return new ArrayList<>();
    }
}
