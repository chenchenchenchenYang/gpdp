package com.yh.mfox.gpdp.service;

import java.util.List;
import java.util.Map;

public interface SjzcService {
    Map<String, Object> getCount();

    Map<String,Object> getJrpm();

    Map<String,Object> getJrpc();

    Map<String,Object> getExchange();

    Map<String,Object> getSjzl();

    List<Map<String, Object>> getXlpm();

    Map<String,Object> getZtzy();

    List<Map<String, Object>> getBmsx();

}
