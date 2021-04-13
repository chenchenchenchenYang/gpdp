package com.yh.mfox.gpdp.controller;

import com.yh.mfox.gpdp.service.JyrqService;
import com.yh.mfox.gpdp.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月12日 19:42
 * @Description:就业人群
 */
@RestController
@RequestMapping("/jyrq")
public class JyrqController {
    @Autowired
    private JyrqService jyrqService;

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月12日 下午 08:22:08
     * @Description: 就业统计情况
     */
    @PostMapping("/infoCount")
    public Map<String, Object> getQzInfo(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",jyrqService.getInfoCount());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月12日 下午 08:21:56
     * @Description: 就业类型
     */
    @PostMapping("/typeInfo")
    public Map<String, Object> getTypeInfo(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",jyrqService.getTypeInfo());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月12日 下午 08:34:00
     * @Description: 就业性别分析
     */
    @PostMapping("/sexInfo")
    public Map<String, Object> getSexInfo(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",jyrqService.getSexInfo());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月13日 上午 10:45:02
     * @Description: 就业是否有组织劳务输出
     */
    @PostMapping("/lwsc")
    public Map<String, Object> getLwscInfo(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",jyrqService.getLwscInfo());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月13日 上午 11:05:20
     * @Description: 统计
     */
    @PostMapping("/count")
    public Map<String, Object> getCount(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",jyrqService.getCount());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }


    /**
     * @Author: Wangcheny
     * @Date: 2021年04月13日 下午 12:59:39
     * @Description: 学历分析
     */
    @PostMapping("/edu")
    public Map<String, Object> getEduCount(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",jyrqService.getEduCount());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }
}
