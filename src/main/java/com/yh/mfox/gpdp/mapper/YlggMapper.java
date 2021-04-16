package com.yh.mfox.gpdp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月16日 11:12
 * @Description:
 */
@Mapper
public interface YlggMapper {
    List<Map<String, Object>> queryRsCount(@Param("type") String type, @Param("date")String date);

    List<Map<String, Object>> queryMzCount(@Param("type") String type, @Param("date")String date);

    List<Map<String, Object>> queryZyCount(@Param("type") String type, @Param("date")String date);
}
