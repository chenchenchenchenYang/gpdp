package com.yh.mfox.gpdp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ZhlyMapper {
    List<Map<String,Object>> queryCount();

    List<Map<String, Object>> queryHxdjzb();

    List<Map<String, Object>> queryDyx();

    List<Map<String, Object>> queryFhwz();

    List<Map<String, Object>> queryHly(@Param("name") String name);

    List<Map<String, Object>> queryZfdw(@Param("dwmc") String dwmc);

    List<Map<String, Object>> queryZbxq(@Param("dwmc") String dwmc,@Param("zbmc") String zbmc);

    List<Map<String, Object>> queryJbxx(@Param("lcmc") String lcmc);
}
