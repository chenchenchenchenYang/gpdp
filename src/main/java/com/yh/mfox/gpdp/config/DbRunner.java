package com.yh.mfox.gpdp.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbRunner implements CommandLineRunner {

    private JSONObject json;
    @Autowired
    private NettyClient client;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("TCP 认证");
        json = new JSONObject();
        json.put("msg", "req");
        json.put("action", "cmuLogin");
        json.put("act_seq", 102);
        json.put("mid", -1);
        json.put("username", "admin");
        json.put("password", "123456789@Usc?.");
        json.put("cuid", 0);
        client.sendMsg(JSONObject.toJSONString(json) + "**" );
    }
}
