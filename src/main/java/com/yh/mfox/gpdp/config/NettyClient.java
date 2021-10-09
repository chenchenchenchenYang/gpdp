package com.yh.mfox.gpdp.config;

import com.yh.mfox.gpdp.util.YmlUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
public class NettyClient {

    private static final Logger log = LoggerFactory.getLogger(NettyClient.class);

    private EventLoopGroup group = new NioEventLoopGroup();

    private Integer port = Integer.parseInt(YmlUtil.getConfigByYml("netty.port"));

    private String host = YmlUtil.getConfigByYml("netty.host");

    private SocketChannel socketChannel;

    /**
     * 发送消息
     */
    public void sendMsg(String msg) {
        socketChannel.writeAndFlush(msg);
    }

    @PostConstruct
    public void start() {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(host, port)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new NettyClientInitializer());
        ChannelFuture future = bootstrap.connect();
        //客户端断线重连逻辑
        future.addListener((ChannelFutureListener) future1 -> {
            if (future1.isSuccess()) {
                log.info("连接Netty服务端成功");
            } else {
                log.info("连接失败，进行断线重连");
                future1.channel().eventLoop().schedule(() -> start(), 20, TimeUnit.SECONDS);
            }
        });
        socketChannel = (SocketChannel) future.channel();
    }
}
