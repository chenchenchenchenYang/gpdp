package com.yh.mfox.gpdp.service;

import java.util.List;
import java.util.Map;

public interface EduService {
    Map<String, Object> getCount();

    List<Map<String, Object>> getXlfb();

    List<Map<String, Object>> getByyx();

    Map<String, Object> getXbbl(String date);

    Map<String, Object> getJszb();

    Map<String, Object>  getType();

    List<Map<String, Object>> getBase(String type, String name);

    List<Map<String, Object>> getXsrs(String date);

    List<Map<String, Object>> getNlfb();

    List<Map<String, Object>> getHjsl();

    List<Map<String, Object>> getHkszd();

    List<Map<String, Object>> getGzjy();

    List<Map<String, Object>> getNjfb();

    List<Map<String, Object>> getHjtj();

    List<Map<String, Object>> getZxxstj();

    List<Map<String, Object>> getSsqk();

    List<Map<String, Object>> getXszb();
}
