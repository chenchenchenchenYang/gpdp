package com.yh.mfox.gpdp.mapper.add;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface InsertMapper {
    int insertVideos(JSONObject sps);
}
