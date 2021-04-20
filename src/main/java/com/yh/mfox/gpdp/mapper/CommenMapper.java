package com.yh.mfox.gpdp.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommenMapper {
    List<Map<String, Object>> querySp(Map<String, Object> params);

    long querySpCount(Map<String, Object> params);
}
