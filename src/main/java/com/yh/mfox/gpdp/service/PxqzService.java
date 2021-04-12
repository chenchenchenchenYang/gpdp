package com.yh.mfox.gpdp.service;

import java.util.List;
import java.util.Map;

public interface PxqzService {
    List<Map<String,Object>> getCount();

    Map<String, Object> getRyInfo();

    List<Map<String,Object>> getGzCount();

    List<Map<String,Object>> getXbCount();

    Map<String, Object> getPxInfo();

    Map<String, Object> getQzInfo();
}
