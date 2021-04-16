package com.yh.mfox.gpdp.service;

import java.util.Map;

public interface YlggService {
    Map<String, Object> getRsCount(String type,String date);

    Map<String, Object> getSrCount(String type, String date);
}
