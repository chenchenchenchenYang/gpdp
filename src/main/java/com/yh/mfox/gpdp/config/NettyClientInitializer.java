package com.yh.mfox.gpdp.config;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ByteBuf delimiter = Unpooled.copiedBuffer("**".getBytes());
        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024*1024,delimiter));
        socketChannel.pipeline().addLast(new StringDecoder());
        socketChannel.pipeline().addLast(new StringEncoder());
        socketChannel.pipeline().addLast(new NettyClientHandler());
    }
}
