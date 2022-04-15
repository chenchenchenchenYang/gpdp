package com.yh.mfox.gpdp.mapper.query;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ZhlyMapper {
    Map<String,Object> queryCount();

    List<Map<String, Object>> queryHxdjzb();

    Map<String, Object> queryDyx();

    Map<String, Object> queryFhwz();

    List<Map<String, Object>> queryHly(@Param("name") String name);

    List<Map<String, Object>> queryZfdw(@Param("dwmc") String dwmc);

    List<Map<String, Object>> queryZbxq(@Param("dwmc") String dwmc,@Param("zbmc") String zbmc);

    List<Map<String, Object>> queryJbxx(@Param("lcmc") String lcmc);

    Map<String, Object> querySlfgl();

    Map<String, Object> queryGylxx();

    Map<String, Object> queryCountZfdw();

    Map<String, Object> queryHlfhwz();

    Map<String, Object> queryLyzytj();
}
