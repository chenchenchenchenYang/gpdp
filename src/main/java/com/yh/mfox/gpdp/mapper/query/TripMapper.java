package com.yh.mfox.gpdp.mapper.query;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TripMapper {
    List<Map<String, Object>> queryRsMonth(@Param("date") String date);

    List<Map<String, Object>> queryReport(@Param("date") String date);

    List<Map<String, Object>> queryRank(@Param("date") String date);

    List<Map<String, Object>> queryRsqs(@Param("date") String date);

    List<Map<String, Object>> queryMpMonth(@Param("date") String date);

    List<Map<String, Object>> queryRjrsMonth(@Param("date") String date);

    List<Map<String, Object>> queryRjrsCount(@Param("date") String date);

    List<Map<String, Object>> querySfq(String date);

    List<Map<String, Object>> queryCwCount();

    List<Map<String, Object>> queryGis();

    List<Map<String, Object>> queryWlptzb();

    List<Map<String, Object>> queryWwbhCount();

    List<Map<String, Object>> queryWwbh(@Param("jb") String jb);
}
