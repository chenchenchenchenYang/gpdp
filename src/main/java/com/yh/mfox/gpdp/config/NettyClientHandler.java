package com.yh.mfox.gpdp.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger log = LoggerFactory.getLogger(NettyClientHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端Active .....");
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
        /*if ("cmuInitResData".equals(result.get("action"))) {
            Object children = node.get("children");
            if (null == children) return;
            aa((JSONArray) children);
        } else if ("cmuQueryResData".equals(result.get("action"))) {
            resourcetypeid = node.getInteger("resourcetypeid");
            if (resourcetypeid == 100) {
                // 保存
                CodeCache.list.add(node);
            } else {
                Object children = node.get("children");
                if (null != children) aa((JSONArray) children);
            }
        }*/
    }
    private  Integer resourcetypeid;

    private void aa(JSONArray child) {
        for (Object obj : child) {
            JSONObject json = (JSONObject) obj;
            resourcetypeid = json.getInteger("resourcetypeid");
            if (resourcetypeid == 100) {
                // 保存
                CodeCache.list.add(json);
            } else {
                Object children = json.get("children");
                if (null == children) {
                    if (resourcetypeid == 200){
                        CodeCache.queue.add(json.getInteger("resourceid"));
                    }
                }else {
                    aa((JSONArray) children);
                }
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
