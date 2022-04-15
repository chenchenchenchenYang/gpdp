package com.yh.mfox.gpdp.service.impl;

import com.yh.mfox.gpdp.mapper.query.ZhlyMapper;
import com.yh.mfox.gpdp.service.ZhlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZhlyServiceImpl implements ZhlyService {
    @Autowired
    private ZhlyMapper zhlyMapper;

    @Override
    public Map<String, Object> getCount() {
        return zhlyMapper.queryCount();
    }

    @Override
    public List<Map<String, Object>> getHxdjzb() {
        return zhlyMapper.queryHxdjzb();
    }

    @Override
    public Map<String, Object> getDyx() {
        return zhlyMapper.queryDyx();
    }

    @Override
    public Map<String, Object> getFhwz() {
        return zhlyMapper.queryFhwz();
    }

    @Override
    public List<Map<String, Object>> getHly(String name) {
        return zhlyMapper.queryHly(name);
    }

    @Override
    public List<Map<String, Object>> getZfdw(String dwmc) {
        return zhlyMapper.queryZfdw(dwmc);
    }

    @Override
    public List<Map<String, Object>> getZbxq(String dwmc,String zbmc) {
        return zhlyMapper.queryZbxq(dwmc,zbmc);
    }

    @Override
    public List<Map<String, Object>> getJbxx(String lcmc) {
        return zhlyMapper.queryJbxx(lcmc);
    }

    @Override
    public Map<String, Object> getSlfgl() {
        return zhlyMapper.querySlfgl();
    }

    @Override
    public Map<String, Object> getGylxx() {
        return zhlyMapper.queryGylxx();
    }

    @Override
    public Map<String, Object> getSytj() {
        HashMap<String,Object> map = new HashMap<>();
        // 森林覆盖率
        map.putAll(zhlyMapper.querySlfgl());
        // 公益林
        map.putAll(zhlyMapper.queryGylxx());
        // 驻防队伍数
        map.putAll(zhlyMapper.queryCountZfdw());
        // 护林员、队伍装备数
        map.putAll(zhlyMapper.queryHlfhwz());
        // 林场总数
        map.putAll(zhlyMapper.queryLyzytj());
        return map;
    }
}
