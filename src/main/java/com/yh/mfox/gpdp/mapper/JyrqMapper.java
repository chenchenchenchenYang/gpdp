package com.yh.mfox.gpdp.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface JyrqMapper {

    List<Map<String, Object>> queryInfoCount();

    List<Map<String, Object>> queryTypeInfo();

    List<Map<String, Object>> querySexInfo();

    List<Map<String, Object>> querySexInfoBak();

    List<Map<String, Object>> queryLwscInfo();

    List<Map<String, Object>> queryCount();

    List<Map<String, Object>> queryEduCount();

    List<Map<String, Object>> queryAgeCount();

    List<Map<String, Object>> queryJyType();

    List<Map<String, Object>> queryZzType();

    List<Map<String, Object>> queryJyfx();

    List<Map<String, Object>> queryXytType();

    List<Map<String, Object>> queryLhType();
}
