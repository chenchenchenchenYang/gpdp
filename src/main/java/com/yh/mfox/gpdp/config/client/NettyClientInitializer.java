package com.yh.mfox.gpdp.config.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Autowired
    private NettyClient nettyClient;
    @Autowired
    private NettyClientHandler handler;
    @Override
    protected void initChannel(SocketChannel socketChannel) {
        ByteBuf delimiter = Unpooled.copiedBuffer("**".getBytes());
        socketChannel.pipeline().addLast(new IdleStateHandler(0, 10, 0));
        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024*1024,delimiter));
        socketChannel.pipeline().addLast(new StringDecoder());
        socketChannel.pipeline().addLast(new StringEncoder());
        socketChannel.pipeline().addLast(new HeartbeatHandler(nettyClient));
        socketChannel.pipeline().addLast(handler);
    }
}
