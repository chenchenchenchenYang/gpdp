package com.yh.mfox.gpdp.mapper.query;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RrczMapper {
    List<Map<String,Object>> queryResidenceAddr();

    List<Map<String, Object>> queryResidence();

    List<Map<String, Object>> queryCount();

    List<Map<String, Object>> queryProfessNum();

    List<Map<String, Object>> queryProfessRate();

    List<Map<String, Object>> queryVocationNum();

    List<Map<String, Object>> queryVocationRate();

    List<Map<String, Object>> queryCzIn();

    List<Map<String, Object>> queryCzBd();

    List<Map<String, Object>> queryCzEdu();

    Map<String, Object> querySbcxByNameAndCard(@Param("name") String name,@Param("idCard") String idCard);

}
