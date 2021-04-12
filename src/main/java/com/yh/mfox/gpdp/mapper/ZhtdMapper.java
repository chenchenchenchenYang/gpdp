package com.yh.mfox.gpdp.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ZhtdMapper {
    List<Map<String, Object>> queryDtgl();

    List<Map<String, Object>> querySceneCount();

    List<Map<String, Object>> queryDtCount();

    List<Map<String, Object>> queryDtType();

    List<Map<String, Object>> queryWbCount();

    List<Map<String, Object>> queryDtAvg();

    List<Map<String, Object>> queryMonthAvg();

    List<Map<String, Object>> queryWbTotal();
}
