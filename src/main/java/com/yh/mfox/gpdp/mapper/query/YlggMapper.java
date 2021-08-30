package com.yh.mfox.gpdp.mapper.query;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月16日 11:12
 * @Description:
 */
@Mapper
public interface YlggMapper {
    List<Map<String, Object>> queryRsCount(@Param("type") String type, @Param("date")String date);

    List<Map<String, Object>> queryMzCount(@Param("type") String type, @Param("date")String date);

    List<Map<String, Object>> queryZyCount(@Param("type") String type, @Param("date")String date);

    List<Map<String, Object>> querySsjcDay(@Param("date") String date);

    List<Map<String, Object>> querySsjcWeek(@Param("date") String date);

    List<Map<String, Object>> querySsjcMonth(@Param("date") String date);

    List<Map<String, Object>> querySsjcYear(@Param("date") String date);

    List<Map<String, Object>> queryRyrsDay(@Param("date") String date);

    List<Map<String, Object>> queryRyrsWeek(@Param("date") String date);

    List<Map<String, Object>> queryRyrsMonth(@Param("date") String date);

    List<Map<String, Object>> queryRyrsYear(@Param("date") String date);

    List<Map<String, Object>> queryJcfDay(@Param("date") String date);

    List<Map<String, Object>> queryJcfWeek(@Param("date") String date);

    List<Map<String, Object>> queryJcfMonth(@Param("date") String date);

    List<Map<String, Object>> queryJcfYear(@Param("date") String date);

    List<Map<String, Object>> queryXl();

    List<Map<String, Object>> queryZc();
}
