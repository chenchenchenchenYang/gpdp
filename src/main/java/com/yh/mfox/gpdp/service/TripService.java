package com.yh.mfox.gpdp.service;

import java.util.List;
import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月14日 16:33
 * @Description:
 */
public interface TripService {
    List<Map<String,Object>> getRsMonth(String date);

    Map<String,Object> getReport(String date);

    List<Map<String,Object>> getRank();

    List<Map<String,Object>> getRsqs( String date);

    List<Map<String,Object>> getMpMonth(String date);

    List<Map<String,Object>> getRjrsMonth(String date);

    Map<String,Object> getRjrsCount(String date);

    Map<String,Object> getSfq(String date);

    List<Map<String,Object>> getCwCount();

    List<Map<String,Object>> getGis();

    List<Map<String,Object>> getWlptzb();

    Map<String,Object> getWwbh();
}
