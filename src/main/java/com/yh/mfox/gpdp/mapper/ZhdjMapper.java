package com.yh.mfox.gpdp.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月08日 17:53
 * @Description:
 */
@Mapper
public interface ZhdjMapper {
    List<Map<String,Object>> selectDljgAll();
}
