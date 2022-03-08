package com.yh.mfox.gpdp.config.client;

import com.alibaba.fastjson.JSONObject;
import com.yh.mfox.gpdp.util.RedisUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ChannelHandler.Sharable
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger log = LoggerFactory.getLogger(NettyClientHandler.class);

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        JSONObject json = new JSONObject();
        json.put("msg", "req");
        json.put("action", "cmuLogin");
        json.put("act_seq", 102);
        json.put("mid", -1);
        json.put("username", "admin");
        json.put("password", "123456789@Usc?.");
        json.put("cuid", 0);
        ctx.writeAndFlush(json.toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            String res = msg.toString();
            JSONObject node;
            // log.info("客户端收到消息: {}", res);
            JSONObject result = JSONObject.parseObject(res);
            node = JSONObject.parseObject(result.get("node") + "");
            if (res.contains("cmuLogin") || res.contains("cmuHeartBeat") || res.contains("cmuLogout") || res.contains("cmuReportPuStatus")) return;
            if (node != null && "cmuInitResData".equals(result.get("action"))) {
                redisUtil.set("root", node);
            } else if (node != null && "cmuQueryResData".equals(result.get("action"))) {
                redisUtil.set(node.get("resourceid") + "", node);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e + " -- " + msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        NettyClient client = new NettyClient();
        log.info("服务器中途断线，重连！");
        super.channelInactive(ctx);
        client.start();
    }
}
