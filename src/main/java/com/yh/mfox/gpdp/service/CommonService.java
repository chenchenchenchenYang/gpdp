package com.yh.mfox.gpdp.service;

import java.util.List;
import java.util.Map;

public interface CommonService {
    Map<String, Object> getSp(int page,int size,String yj, String ej, String sj);

    List<Map<String, Object>> getSpType();
}
