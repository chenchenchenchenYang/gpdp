package com.yh.mfox.gpdp.service;

import java.util.List;
import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月12日 15:49
 * @Description:
 */
public interface ZhdtService {
    Map<String, Object> getDtgl();

    List<Map<String,Object>> getSceneCount();

    List<Map<String,Object>> getDtCount();

    List<Map<String,Object>> getDtType();

    List<Map<String,Object>> getWbCount();

    List<Map<String,Object>> getDtAvg();

    List<Map<String,Object>> getMonthAvg();

    List<Map<String,Object>> getWbTotal();
}
