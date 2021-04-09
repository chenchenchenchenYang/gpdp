package com.yh.mfox.gpdp.mapper;

import com.yh.mfox.gpdp.model.DLJG;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月08日 17:52
 * @Description:
 */
@Mapper
public interface ZhdjMapper {
    List<Map<String,Object>> selectDljgAll();
}
