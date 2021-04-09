package com.yh.mfox.gpdp.service.impl;

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
    public List<Map<String,Object>> getDljgAll() {
        return zhdjMapper.selectDljgAll();
    }
}
