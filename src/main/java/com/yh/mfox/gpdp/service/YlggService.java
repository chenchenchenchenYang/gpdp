package com.yh.mfox.gpdp.service;

import java.util.List;
import java.util.Map;

public interface YlggService {
    Map<String, Object> getRsCount(String type,String date);

    Map<String, Object> getSrCount(String type, String date);

    List<Map<String, Object>> getSsjc(String type, String date);

    List<Map<String, Object>> getRyrs(String type, String date);

    List<Map<String, Object>> getJcf(String type, String date);

    List<Map<String, Object>> getXl();

    List<Map<String, Object>> getZc();
}
