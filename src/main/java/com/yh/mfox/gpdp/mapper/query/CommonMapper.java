package com.yh.mfox.gpdp.mapper.query;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommonMapper {
    List<Map<String, Object>> querySp(Map<String, Object> params);

    long querySpCount(Map<String, Object> params);

    List<Map<String, Object>> querySpType();

    List<Map<String, Object>> queryEjfl(@Param("splx") String splx);
}