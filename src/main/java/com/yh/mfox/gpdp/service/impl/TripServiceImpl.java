package com.yh.mfox.gpdp.service.impl;

import com.yh.mfox.gpdp.mapper.query.TripMapper;
import com.yh.mfox.gpdp.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripMapper tripMapper;

    @Override
    public List<Map<String, Object>> getRsMonth(String date) {
        return tripMapper.queryRsMonth(date);
    }

    @Override
    public Map<String, Object> getReport(String date) {
        Map<String,Object> res = new HashMap<>();
        LocalDate from = LocalDate.of(2021, 1, 1);
        long day = LocalDate.now().toEpochDay() - from.toEpochDay();
        res.put("day",day);
        res.put("data",tripMapper.queryReport(date));
        return res;
    }

    @Override
    public List<Map<String, Object>> getRank() {
        return tripMapper.queryRank();
    }

    @Override
    public List<Map<String, Object>> getRsqs(String date) {
        return tripMapper.queryRsqs(date);
    }

    @Override
    public List<Map<String, Object>> getMpMonth(String date) {
        return tripMapper.queryMpMonth(date);
    }

    @Override
    public List<Map<String, Object>> getRjrsMonth(String date) {
        return tripMapper.queryRjrsMonth(date);
    }

    @Override
    public Map<String, Object> getRjrsCount(String date) {
        List<Map<String, Object>> maps  = tripMapper.queryRjrsCount(date);
        if(null ==maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0);
    }

    @Override
    public Map<String, Object> getSfq(String date) {
        List<Map<String, Object>> maps = tripMapper.querySfq(date);
        if(null ==maps || maps.isEmpty()) return new HashMap<>();
        return maps.get(0);
    }

    @Override
    public List<Map<String, Object>> getCwCount() {
        return tripMapper.queryCwCount();
    }

    @Override
    public List<Map<String, Object>> getGis() {
        return tripMapper.queryGis();
    }
}
