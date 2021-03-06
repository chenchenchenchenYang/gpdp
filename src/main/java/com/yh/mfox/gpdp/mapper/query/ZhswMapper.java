package com.yh.mfox.gpdp.mapper.query;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ZhswMapper {
    List<Map<String, Object>> queryYsl(@Param("year") String year);

    List<Map<String, Object>> queryGgqk();

    List<Map<String, Object>> queryZlmj(@Param("year") String year);

    List<Map<String, Object>> queryYsgc(@Param("year") String year);

    List<Map<String, Object>> queryZlssy(@Param("year") String year);

    List<Map<String, Object>> queryHlInfo(@Param("name") String name);

    List<Map<String, Object>> querySkInfp(@Param("name") String name);

    List<Map<String, Object>> queryXqjyl();

    List<Map<String, Object>> queryDmYear();

    List<Map<String, Object>> queryDmCount(@Param("name") String name, @Param("year") String year);

    List<Map<String, Object>> queryDmdetail(@Param("page") int page, @Param("size") int size);

    long queryCount();
}
