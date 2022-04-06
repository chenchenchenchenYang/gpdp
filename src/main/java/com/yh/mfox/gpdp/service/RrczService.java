package com.yh.mfox.gpdp.service;

import java.util.List;
import java.util.Map;

public interface RrczService {
    List<Map<String,Object>> getResidenceAddr();

    List<Map<String,Object>> getResidence();

    Map<String, Object> getCount();

    Map<String, Object> getProfess();

    Map<String, Object> getVocation();

    Map<String, Object> getCz();

    Map<String, Object> querySbcx(String name, String idCard);
}
