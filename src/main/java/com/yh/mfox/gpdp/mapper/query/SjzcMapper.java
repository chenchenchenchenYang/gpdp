package com.yh.mfox.gpdp.mapper.query;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SjzcMapper {

    List<Map<String, Object>> queryCount();

    List<Map<String, Object>> queryJrzl();

    List<Map<String, Object>> queryRzl();

    List<Map<String, Object>> queryQb();

    List<Map<String, Object>> queryKbsl();

    List<Map<String, Object>> querySpsl();

    List<Map<String, Object>> queryQbpc();

    List<Map<String, Object>> queryExchange();

    List<Map<String, Object>> querySjzl();

    List<Map<String, Object>> queryXlpmLx();

    List<Map<String, Object>> queryXlpmSs();

    List<Map<String, Object>> queryXlpmQb();

    List<Map<String, Object>> queryWts();

    List<Map<String, Object>> querySpCount();

    List<Map<String, Object>> queryZtzy();

    List<Map<String, Object>> queryBmsx();
}
