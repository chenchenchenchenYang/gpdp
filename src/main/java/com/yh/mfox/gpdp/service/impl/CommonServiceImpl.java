package com.yh.mfox.gpdp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.yh.mfox.gpdp.config.client.NettyClient;
import com.yh.mfox.gpdp.mapper.query.CommonMapper;
import com.yh.mfox.gpdp.service.CommonService;
import com.yh.mfox.gpdp.util.RedisUtil;
import com.yh.mfox.gpdp.util.SyncFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class CommonServiceImpl implements CommonService {

    private static final Logger log = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Autowired
    private CommonMapper commenMapper;
    @Autowired
    private NettyClient nettyClient;

    @Autowired
    private RedisUtil redisUtil;

    private JSONObject json;

    @Override
    public Map<String, Object> getSp(int page, int size, String yj, String ej, String sj) {
        Map<String, Object> params = new HashMap<>();
        params.put("page", (page - 1) * size);
        params.put("size", size);
        params.put("yj", yj);
        params.put("ej", ej);
        params.put("sj", sj);

        Map<String, Object> result = new HashMap<>();
        result.put("page", page);
        result.put("size", size);
        result.put("count", commenMapper.querySpCount(params));
        result.put("rows", commenMapper.querySp(params));
        return result;
    }

    @Override
    public List<Map<String, Object>> getSpType() {
        List<Map<String,Object>> l = new ArrayList<>();
        List<Map<String, Object>> list = commenMapper.querySpType();
        if (list.isEmpty()) return l;
        Map<String, Object> result;
        for (Map<String, Object> map : list) {
            result = new HashMap<>();
            String splx = map.get("SPLX") + "";
            result.put("name",splx);
            result.put("child",commenMapper.queryEjfl(splx));
            l.add(result);
        }
        return l;
    }

    @Override
    public JSONObject spInit(){
        json= new JSONObject();
        json.put("msg", "req");
        json.put("action", "cmuInitResData");
        json.put("act_seq", 102);
        json.put("mid", 9);
        send(json);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return JSONObject.parseObject(redisUtil.get("root")+"");
    }

    @Override
    public JSONObject queryNode(int resourceId) {
        json= new JSONObject();
        json.put("msg", "req");
        json.put("action", "cmuQueryResData");
        json.put("act_seq", 102);
        json.put("mid", 9);
        json.put("resourceid", resourceId);
        send(json);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return JSONObject.parseObject(redisUtil.get(resourceId+"")+"");
    }

    private void send(JSONObject json){
        nettyClient.send(json.toJSONString());
    }

    private JSONObject sendSyncMsg(JSONObject content, String requestId) {
        SyncFuture<JSONObject> syncFuture = new SyncFuture<>();
        // ???????????????
        futureCache.put(requestId, syncFuture);
        // ????????????
        content.put("requestId",requestId);
        // ??????????????????
        return nettyClient.sendSyncMsg(content.toJSONString(), syncFuture);
    }

    @Override
    public void ackSyncMsg(JSONObject msg) {
        String requestId = msg.getString("requestId");

        // ????????????????????????
        SyncFuture<JSONObject> syncFuture = futureCache.getIfPresent(requestId);

        // ????????????null, ???????????????
        if(syncFuture != null) {
            syncFuture.setResponse(msg);
            //????????????
            futureCache.invalidate(requestId);
        }
    }

    private static LoadingCache<String, SyncFuture> futureCache = CacheBuilder.newBuilder()
            //????????????????????????????????????10
            .initialCapacity(100)
            // maximumSize ??????????????????
            .maximumSize(10000)
            //?????????????????????20??????????????????????????????????????????????????????
            .concurrencyLevel(20)
            // expireAfterWrite??????????????????8????????????
            .expireAfterWrite(8, TimeUnit.SECONDS)
            //???????????????????????????
            .removalListener(notification -> log.debug("LoadingCache: {} was removed, cause is {}",notification.getKey(), notification.getCause()))
            //build?????????????????????CacheLoader??????????????????????????????CacheLoader???????????????????????????
            .build(new CacheLoader<String, SyncFuture>() {
                @Override
                public SyncFuture load(String key) throws Exception {
                    // ?????????key?????????????????????????????????????????????
                    return null;
                }
            });

}
