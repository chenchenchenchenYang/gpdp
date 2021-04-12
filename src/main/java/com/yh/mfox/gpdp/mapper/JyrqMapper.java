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
}