package com.yh.mfox.gpdp.util;


import java.util.HashMap;
import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月09日 10:54
 * @Description:
 */
public class R {

    public R() {
    }

    public static Map<String,Object> ok(Integer code , String msg, Object data){
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",msg);
        map.put("data",data);
        return map;
    }

    public static Map<String,Object> error(Integer code ,String msg){
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",msg);
        return map;
    }
}
