
package com.yh.mfox.gpdp.config.client;

import com.alibaba.fastjson.JSONObject;
import com.yh.mfox.gpdp.util.SyncFuture;
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
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private NettyClientInitializer clientInitializer;

    /**
     * 发送消息
     */
    public JSONObject sendSyncMsg(String msg, SyncFuture<JSONObject> syncFuture) {
        JSONObject result = new JSONObject();
        ;
        try {
            ChannelFuture future = socketChannel.writeAndFlush(msg);
            future.addListener((ChannelFutureListener) future1 -> {
                if (future1.isSuccess()) {
                    System.out.println("===========发送成功");
                } else {
                    System.out.println("------------------发送失败");
                }
            });
            // 等待 8 秒
            result = syncFuture.get(8, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void send(String msg) {
        ChannelFuture future = socketChannel.writeAndFlush(msg);
        future.addListener((ChannelFutureListener) future1 -> {
            if (future1.isSuccess()) {
                System.out.println("===========发送成功");
            } else {
                System.out.println("------------------发送失败");
                log.info("失败内容: {} " + msg);
            }
        });

    }

    @PostConstruct
    public void start() {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(host, port)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(clientInitializer);
        ChannelFuture future = bootstrap.connect();
        //客户端断线重连逻辑
        future.addListener((ChannelFutureListener) future1 -> {
            if (future1.isSuccess()) {
                log.info("连接Netty服务端成功");
            } else {
                log.info("连接失败，进行断线重连");
                future1.channel().eventLoop().schedule(this::start, 20, TimeUnit.SECONDS);
            }
        });
        socketChannel = (SocketChannel) future.channel();
    }
}
