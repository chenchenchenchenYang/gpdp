package com.yh.mfox.gpdp.mapper.add;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InsertMapper {
    int insertVideos(@Param("resourceid") Integer resourceid,
                     @Param("name") String name,
                     @Param("longitude") String longitude,
                     @Param("latitude") String latitude,
                     @Param("statue") Integer statue,
                     @Param("mainCodeStream") String  mainCodeStream,
                     @Param("subCodeStream") String  subCodeStream);
}
