package com.yh.mfox.gpdp.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Wangcheny
 * @date: 2021年08月27日 12:24
 * @Description:
 */

@Component
public class CodeCache {
    public static Queue<Integer> queue = new LinkedList<>();

    public static Queue<JSONObject> list = new LinkedList<>();

    public static boolean flag = true;

    public static Queue<Integer> getQueue() {
        return queue;
    }

    public static void setQueue(Queue<Integer> queue) {
        CodeCache.queue = queue;
    }
}