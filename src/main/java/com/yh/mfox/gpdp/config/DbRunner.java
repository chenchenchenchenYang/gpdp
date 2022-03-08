package com.yh.mfox.gpdp.config;

import com.alibaba.fastjson.JSONObject;
import com.yh.mfox.gpdp.config.client.NettyClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/*@Component*/
public class DbRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(DbRunner.class);

    private JSONObject json;
    @Autowired
    private NettyClient client;

    @Override
    public void run(String... args) throws Exception {
        log.info("TCP 认证");
        json = new JSONObject();
        json.put("msg", "req");
        json.put("action", "cmuLogin");
        json.put("act_seq", 102);
        json.put("mid", -1);
        json.put("username", "admin");
        json.put("password", "123456789@Usc?.");
        json.put("cuid", 0);
        client.send(JSONObject.toJSONString(json) + "**" );
    }
}
