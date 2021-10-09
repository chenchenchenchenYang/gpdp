package com.yh.mfox.gpdp.config;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger log = LoggerFactory.getLogger(NettyClientHandler.class);

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
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        IdleStateEvent event = (IdleStateEvent) evt;
        log.info("Client,Idle:" + event.state());
        switch (event.state()) {
            case READER_IDLE:
            case ALL_IDLE:
                break;
            case WRITER_IDLE:
                JSONObject json = new JSONObject();
                json.put("msg", "req");
                json.put("action", "cmuHeartBeat");
                json.put("act_seq", -1);
                json.put("mid", -1);
                ctx.writeAndFlush(JSONObject.toJSONString(json) + "**").addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
                break;
            default:
                super.userEventTriggered(ctx, evt);
                break;
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            String res = msg.toString();
            log.info("客户端收到消息: {}", res);
            if (res.contains("cmuLogin") || res.contains("cmuHeartBeat") || res.contains("cmuLogout") || res.contains("cmuReportPuStatus")) return;
            JSONObject result = JSONObject.parseObject(res);
            JSONObject node = JSONObject.parseObject(result.get("node") + "");
            CodeCache.list.add(node);
        }catch (Exception e){
            e.printStackTrace();
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
        EventLoop eventLoop = ctx.channel().eventLoop();
        eventLoop.schedule(client::start, 20, TimeUnit.SECONDS);
        super.channelInactive(ctx);
    }

}
