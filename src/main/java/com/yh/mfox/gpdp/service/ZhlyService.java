package com.yh.mfox.gpdp.service;


import java.util.List;
import java.util.Map;

public interface ZhlyService {
    Map<String, Object> getCount();

    List<Map<String, Object>> getHxdjzb();

    Map<String, Object> getDyx();

    Map<String, Object> getFhwz();

    List<Map<String, Object>> getHly(String name);

    List<Map<String, Object>> getZfdw(String dwmc);

    List<Map<String, Object>> getZbxq(String dwmc,String zbmc);

    List<Map<String, Object>> getJbxx(String lcmc);

    Map<String, Object> getSlfgl();

    Map<String, Object> getGylxx();

    Map<String, Object> getSytj();
}
