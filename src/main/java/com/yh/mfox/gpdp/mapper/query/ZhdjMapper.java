package com.yh.mfox.gpdp.mapper.query;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月08日 17:53
 * @Description:
 */
@Mapper
public interface ZhdjMapper {

    List<Map<String,Object>> queryDljgAll();

    List<Map<String, Object>> queryDjfcByType(@Param("type") String type);

    List<Map<String, Object>> queryDyxl();

    List<Map<String, Object>> queryDyxb();

    List<Map<String, Object>> queryDyhy();

    List<Map<String, Object>> queryDyjbqk();

    List<Map<String, Object>> queryDyfc();

    List<Map<String, Object>> queryDdmf();

    List<Map<String, Object>> queryDynljg();

    List<Map<String, Object>> queryFzdyqk();

    List<Map<String, Object>> queryZzxfb();

    List<Map<String, Object>> queryRmgjc();

    List<Map<String, Object>> queryShyk();

    List<Map<String, Object>> queryZyzhd();
}
