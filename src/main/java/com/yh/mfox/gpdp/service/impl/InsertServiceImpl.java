package com.yh.mfox.gpdp.service.impl;

import com.yh.mfox.gpdp.mapper.add.InsertMapper;
import com.yh.mfox.gpdp.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertServiceImpl implements InsertService {
    @Autowired
    private InsertMapper insertMapper;

    @Override
    public int addVideos(Integer resourceid, String name, String longitude, String latitude,
                         Integer statue,String  mainCodeStream,String  subCodeStream) {
        return insertMapper.insertVideos(resourceid,name,longitude,latitude,statue,mainCodeStream,subCodeStream);
    }
}
