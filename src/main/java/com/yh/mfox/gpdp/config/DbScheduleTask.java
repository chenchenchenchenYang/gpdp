package com.yh.mfox.gpdp.config;

import com.alibaba.fastjson.JSONObject;
import com.yh.mfox.gpdp.mapper.add.InsertMapper;
import com.yh.mfox.gpdp.service.InsertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.*;
import java.util.Queue;

@Configuration
@EnableScheduling
public class DbScheduleTask {

    private static final Logger log = LoggerFactory.getLogger(DbScheduleTask.class);

    @Autowired
    private NettyClient client;

    // 3.添加定时任务
    @Scheduled(cron = "0/20 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    @Scheduled(fixedRate = 5000)
    private void configureTasks() {
        JSONObject json = new JSONObject();
        CodeCache.flag = false;
        json.put("msg", "req");
        json.put("action", "cmuHeartBeat");
        json.put("act_seq", -1);
        json.put("mid", -1);
        client.sendMsg(JSONObject.toJSONString(json) + "**");

    }

    public static <T> Queue<T> deepCopy(Queue<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        Queue<T> dest = (Queue<T>) in.readObject();
        return dest;
    }
}
