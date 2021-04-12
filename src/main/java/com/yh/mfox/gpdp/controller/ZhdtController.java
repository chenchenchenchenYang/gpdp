package com.yh.mfox.gpdp.controller;

import com.yh.mfox.gpdp.service.ZhdtService;
import com.yh.mfox.gpdp.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月12日 15:47
 * @Description: 智慧电梯
 */
@RestController
@RequestMapping("/zhdt")
public class ZhdtController {

    @Autowired
    private ZhdtService zhdtService;

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月12日 下午 04:21:59
     * @Description: 电梯概览
     */
    @PostMapping("/gl")
    public Map<String, Object> getDtgl(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",zhdtService.getDtgl());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月12日 下午 04:22:22
     * @Description: 电梯使用场所统计
     */
    @PostMapping("/scene")
    public Map<String, Object> getSceneCount(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",zhdtService.getSceneCount());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月12日 下午 04:22:22
     * @Description: 电梯数量
     */
    @PostMapping("/dtCount")
    public Map<String, Object> getDtCount(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",zhdtService.getDtCount());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月12日 下午 05:11:16
     * @Description: 电梯类型
     */
    @PostMapping("/dtType")
    public Map<String, Object> getDtType(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",zhdtService.getDtType());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月12日 下午 05:13:59
     * @Description: 维保超期数量
     */
    @PostMapping("/wbCount")
    public Map<String, Object> getWbCount(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",zhdtService.getWbCount());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月12日 下午 05:13:59
     * @Description: 电梯各项平均值
     */
    @PostMapping("/dtAvg")
    public Map<String, Object> getDtAvg(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",zhdtService.getDtAvg());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月12日 下午 05:13:59
     * @Description: 月平均维保时长统计
     */
    @PostMapping("/monthAvg")
    public Map<String, Object> getMonthAvg(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",zhdtService.getMonthAvg());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月12日 下午 07:01:19
     * @Description: 单位维保/维保工单总数统计
     */
    @PostMapping("/wbTotal")
    public Map<String, Object> getWbTotal(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",zhdtService.getWbTotal());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }
}
