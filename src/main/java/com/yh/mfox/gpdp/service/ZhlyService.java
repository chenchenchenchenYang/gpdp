package com.yh.mfox.gpdp.service;


import java.util.List;
import java.util.Map;

public interface ZhlyService {
    List<Map<String, Object>> getCount();

    List<Map<String, Object>> getHxdjzb();

    List<Map<String, Object>> getDyx();

    List<Map<String, Object>> getFhwz();

    List<Map<String, Object>> getHly(String name);

    List<Map<String, Object>> getZfdw(String dwmc);

    List<Map<String, Object>> getZbxq(String dwmc,String zbmc);

    List<Map<String, Object>> getJbxx(String lcmc);

    Map<String, Object> getSlfgl();

    List<Map<String, Object>> getGylxx();
}
