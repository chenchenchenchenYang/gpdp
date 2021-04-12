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
}