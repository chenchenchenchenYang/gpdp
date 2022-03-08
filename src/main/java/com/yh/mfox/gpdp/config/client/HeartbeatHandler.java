package com.yh.mfox.gpdp.config.client;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
import io.netty.handler.timeout.IdleStateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author pjmike
 * @create 2018-10-25 17:15
 */
@Component
public class HeartbeatHandler extends ChannelInboundHandlerAdapter {

    private final NettyClient nettyClient;
    @Autowired
    public HeartbeatHandler(NettyClient nettyClient) {
        this.nettyClient = nettyClient;
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        IdleStateEvent event = (IdleStateEvent) evt;
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
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //如果运行过程中服务端挂了,执行重连机制
        EventLoop eventLoop = ctx.channel().eventLoop();
        eventLoop.schedule(nettyClient::start, 10L, TimeUnit.SECONDS);
        super.channelInactive(ctx);
    }
}
