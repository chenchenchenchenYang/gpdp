package com.yh.mfox.gpdp.mapper.query;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface EduMapper {
    Map<String, Object> queryCount();

    List<Map<String, Object>> queryXlfb();

    List<Map<String, Object>> queryByyx();

    List<Map<String, Object>> queryXbbl(@Param("date") String date);

    Map<String, Object> queryJszb();

    List<Map<String, Object>> queryType();

    List<Map<String, Object>> queryBase(@Param("type") String type, @Param("name") String name);

    List<Map<String, Object>> queryXsrs(String date);

    List<Map<String, Object>> queryNlfb();

    List<Map<String, Object>> queryHjsl();

    List<Map<String, Object>> queryHkszd();

    List<Map<String, Object>> queryGzjy();

    List<Map<String, Object>> queryNjfb();

    List<Map<String, Object>> queryHjtj();

    List<Map<String, Object>> queryZxxstj();

    List<Map<String, Object>> querySsqk();

    List<Map<String, Object>> queryXszb();
}
