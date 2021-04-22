package com.yh.mfox.gpdp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface EduMapper {
    List<Map<String, Object>> queryCount();

    List<Map<String, Object>> queryXlfb();

    List<Map<String, Object>> queryByyx();

    List<Map<String, Object>> queryXbbl(@Param("date") String date);

    List<Map<String, Object>> queryJszb();

    List<Map<String, Object>> queryType();

    List<Map<String, Object>> queryBase(@Param("type") String type, @Param("name") String name);

    List<Map<String, Object>> queryXsrs(String date);

    List<Map<String, Object>> queryNlfb();
}
