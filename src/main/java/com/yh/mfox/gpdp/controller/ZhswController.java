package com.yh.mfox.gpdp.controller;

import com.yh.mfox.gpdp.service.ZhswService;
import com.yh.mfox.gpdp.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月21日 10:27
 * @Description: 智慧水务
 */
@RestController
@RequestMapping("/zhsw")
public class ZhswController {

    @Autowired
    private ZhswService zhswService;

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月21日 上午 10:46:26
     * @Description: 全市源水量
     */
    @PostMapping("/ysl")
    public Map<String,Object> getYsl(String year){
        try {
            return R.ok(200,"成功",zhswService.getYsl(year));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月21日 下午 03:27:54
     * @Description: 全市灌溉情况
     */
    @PostMapping("/ggqk")
    public Map<String,Object> getGgqk(){
        try {
            return R.ok(200,"成功",zhswService.getGgqk());
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月21日 下午 04:25:00
     * @Description: 水土流失治理面积，单位(km2)
     */
    @PostMapping("/zlmj")
    public Map<String,Object> getZlmj(String year){
        try {
            if(null == year ||"".equals(year)) return R.error(400,"请求参数错误");
            return R.ok(200,"成功",zhswService.getZlmj(year));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月21日 下午 04:25:00
     * @Description: 农村饮水工程统计
     */
    @PostMapping("/ysgc")
    public Map<String,Object> getYsgc(String year){
        try {
            if(null == year ||"".equals(year)) return R.error(400,"请求参数错误");
            return R.ok(200,"成功",zhswService.getYsgc(year));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月21日 下午 05:06:19
     * @Description: 农村自来水使用情况统计
     */
    @PostMapping("/zlssy")
    public Map<String,Object> getZlssy(String year){
        try {
            if(null == year ||"".equals(year)) return R.error(400,"请求参数错误");
            return R.ok(200,"成功",zhswService.getZlssy(year));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月21日 下午 06:00:40
     * @Description: 河流基本信息统计
     */
    @PostMapping("/hlInfo")
    public Map<String,Object> getHlInfo(String name){
        try {
            return R.ok(200,"成功",zhswService.getHlInfo(name));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月21日 下午 06:18:24
     * @Description:  水库基本信息
     */
    @PostMapping("/skInfp")
    public Map<String,Object> getSkInfp(String name){
        try {
            return R.ok(200,"成功",zhswService.getSkInfp(name));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月21日 下午 06:57:45
     * @Description: 汛期降水量统计
     */
    @PostMapping("/xqjyl")
    public Map<String,Object> getXqjyl(){
        try {
            return R.ok(200,"成功",zhswService.getXqjyl());
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年07月28日 下午 02:01:06
     * @Description:断面监测数据
     */
    @PostMapping("/dmjc")
    public Map<String,Object> getDmjc(){
        try {
            return R.ok(200,"成功",zhswService.getDmjc());
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(400,"失败");
        }
    }

    @PostMapping("/dmdetail")
    public Map<String,Object> getDmdetail(){
        try {
            return R.ok(200,"成功",zhswService.getDmdetail());
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(400,"失败");
        }
    }

}
