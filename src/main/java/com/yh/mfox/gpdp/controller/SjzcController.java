package com.yh.mfox.gpdp.controller;

import com.yh.mfox.gpdp.service.SjzcService;
import com.yh.mfox.gpdp.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/sjzc")
public class SjzcController {
    @Autowired
    private SjzcService sjzcService;

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月24日 下午 02:29:24
     * @Description: 总概览
     */
    @PostMapping("/count")
    public Map<String,Object> getSp(){
        try {
            return R.ok(200,"成功",sjzcService.getCount());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月24日 下午 03:57:24
     * @Description: 接入排名
     */
    @PostMapping("/jrpm")
    public Map<String,Object> getJrpm(){
        try {
            return R.ok(200,"成功",sjzcService.getJrpm());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月24日 下午 04:01:28
     * @Description: 接入排查
     */
    @PostMapping("/jrpc")
    public Map<String,Object> getJrpc(){
        try {
            return R.ok(200,"成功",sjzcService.getJrpc());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月24日 下午 04:11:28
     * @Description: 交换共享
     */
    @PostMapping("/jhgx")
    public Map<String,Object> getExchange(){
        try {
            return R.ok(200,"成功",sjzcService.getExchange());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月24日 下午 04:17:12
     * @Description: 数据质量
     */
    @PostMapping("/sjzl")
    public Map<String,Object> getSjzl(){
        try {
            return R.ok(200,"成功",sjzcService.getSjzl());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月24日 下午 04:41:28
     * @Description: 销量排名
     */
    @PostMapping("/xlpm")
    public Map<String,Object> getXlpm(){
        try {
            return R.ok(200,"成功",sjzcService.getXlpm());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }
}
