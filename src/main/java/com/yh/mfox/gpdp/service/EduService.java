package com.yh.mfox.gpdp.service;

import java.util.List;
import java.util.Map;

public interface EduService {
    Map<String, Object> getCount();

    List<Map<String, Object>> getXlfb();

    List<Map<String, Object>> getByyx();

    Map<String, Object> getXbbl(String date);

    List<Map<String, Object>> getJszb();

    Map<String, Object>  getType();

    List<Map<String, Object>> getBase(String type, String name);

    List<Map<String, Object>> getXsrs(String date);

    List<Map<String, Object>> getNlfb();
}
