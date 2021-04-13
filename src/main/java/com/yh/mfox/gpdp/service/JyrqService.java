package com.yh.mfox.gpdp.service;

import java.util.List;
import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月12日 19:44
 * @Description:
 */
public interface JyrqService {
    List<Map<String, Object>> getInfoCount();

    List<Map<String, Object>> getTypeInfo();

    List<Map<String, Object>> getSexInfo();

    List<Map<String, Object>> getLwscInfo();

    List<Map<String, Object>> getCount();

    List<Map<String, Object>> getEduCount();

    List<Map<String, Object>> getAgeCount();

    List<Map<String, Object>> getJyType();

    List<Map<String, Object>> getZzType();

    List<Map<String, Object>> getJyfx();

    List<Map<String, Object>> getXytType();

    List<Map<String, Object>> getLhType();
}
