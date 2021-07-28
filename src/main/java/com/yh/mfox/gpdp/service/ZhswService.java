package com.yh.mfox.gpdp.service;

import java.util.List;
import java.util.Map;

public interface ZhswService {
    List<Map<String, Object>> getYsl(String year);

    Map<String, Object> getGgqk();

    Map<String, Object> getZlmj(String year);

    Map<String, Object> getYsgc(String year);

    Map<String, Object> getZlssy(String year);

    List<Map<String, Object>> getHlInfo(String name);

    List<Map<String, Object>> getSkInfp(String name);

    List<Map<String, Object>> getXqjyl();

    List<Map<String, Object>> getDmjc();

    Map<String, Object> getDmdetail(int page,int size);

}
