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
            Thread.sleep(2000);
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
            Thread.sleep(2000);
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
        // 放入缓存中
        futureCache.put(requestId, syncFuture);
        // 封装数据
        content.put("requestId",requestId);
        // 发送同步消息
        return nettyClient.sendSyncMsg(content.toJSONString(), syncFuture);
    }

    @Override
    public void ackSyncMsg(JSONObject msg) {
        String requestId = msg.getString("requestId");

        // 从缓存中获取数据
        SyncFuture<JSONObject> syncFuture = futureCache.getIfPresent(requestId);

        // 如果不为null, 则通知返回
        if(syncFuture != null) {
            syncFuture.setResponse(msg);
            //主动释放
            futureCache.invalidate(requestId);
        }
    }

    private static LoadingCache<String, SyncFuture> futureCache = CacheBuilder.newBuilder()
            //设置缓存容器的初始容量为10
            .initialCapacity(100)
            // maximumSize 设置缓存大小
            .maximumSize(10000)
            //设置并发级别为20，并发级别是指可以同时写缓存的线程数
            .concurrencyLevel(20)
            // expireAfterWrite设置写缓存后8秒钟过期
            .expireAfterWrite(8, TimeUnit.SECONDS)
            //设置缓存的移除通知
            .removalListener(notification -> log.debug("LoadingCache: {} was removed, cause is {}",notification.getKey(), notification.getCause()))
            //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
            .build(new CacheLoader<String, SyncFuture>() {
                @Override
                public SyncFuture load(String key) throws Exception {
                    // 当获取key的缓存不存在时，不需要自动添加
                    return null;
                }
            });

}
