package com.yh.mfox.gpdp.mapper;

import org.apache.ibatis.annotations.Mapper;

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
}
