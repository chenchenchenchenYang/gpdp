package com.yh.mfox.gpdp.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月08日 17:55
 * @Description:
 */
public interface ZhdjService {
    List<Map<String,Object>> getDljgAll();

    JSONObject getDjfcByType();

    List<Map<String,Object>> getDyxl();

    List<Map<String,Object>> getDyxb();

    List<Map<String,Object>> getDyhy();

    List<Map<String,Object>> getDyjbqk();

    List<Map<String,Object>> getDyfc();

    List<Map<String,Object>> getDdmf();

    List<Map<String,Object>> getDynljg();

    List<Map<String,Object>> getFzdyqk();

    List<Map<String,Object>> getZzxfb();

    List<Map<String,Object>> getRmgjc();

    List<Map<String,Object>> getShyk();

    List<Map<String,Object>> getZyzhd();
}
