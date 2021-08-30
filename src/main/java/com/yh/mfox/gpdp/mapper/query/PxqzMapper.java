package com.yh.mfox.gpdp.mapper.query;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PxqzMapper {
    List<Map<String, Object>> queryCount();

    List<Map<String, Object>> queryRyQz();

    List<Map<String, Object>> queryRyQZTotal();

    List<Map<String, Object>> queryRyPx();

    List<Map<String, Object>> queryRyPxTotal();

    List<Map<String, Object>> queryXbCount();

    List<Map<String, Object>> queryXbCountBak();

    List<Map<String, Object>> queryPxCount();

    List<Map<String, Object>> queryPxEduCount();

    List<Map<String, Object>> queryPxAgeCount();

    List<Map<String, Object>> queryQzXz();

    List<Map<String, Object>> queryQzCount();

    List<Map<String, Object>> queryPxType();

    List<Map<String, Object>> queryPxTotal();

    List<Map<String, Object>> queryPxTypeInfo();

    List<Map<String, Object>> queryPxRyJyType();

    List<Map<String, Object>> queryQzType();

    List<Map<String, Object>> queryQzTotal();

    List<Map<String, Object>> queryQzTypeInfo();

    List<Map<String, Object>> queryQzRyJyType();

    List<Map<String, Object>> queryDyyx();

    List<Map<String, Object>> querySexInfo(@Param("type") String type);
}
