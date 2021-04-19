package com.yh.mfox.gpdp.controller;

import com.yh.mfox.gpdp.service.TripService;
import com.yh.mfox.gpdp.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月14日 16:32
 * @Description: 智慧旅游
 */
@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月14日 下午 05:11:44
     * @Description: 全市景区接待人数月报
     */
    @PostMapping("/rsMonth")
    public Map<String, Object> getRsMonth(@RequestParam("date") String date) {
        try {
            return R.ok(200,"成功",tripService.getRsMonth(date));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月15日 上午 09:59:38
     * @Description: 运营平台报告
     * @param : date 格式 传年份2020
     */
    @PostMapping("/report")
    public Map<String, Object> getReport(@RequestParam("date") String date) {
        try {
            return R.ok(200,"成功",tripService.getReport(date));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月15日 上午 11:26:22
     * @Description:排行榜
     */
    @PostMapping("/rank")
    public Map<String, Object> getRank() {
        try {
            return R.ok(200,"成功",tripService.getRank());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月15日 下午 02:50:54
     * @Description: 景区人数趋势
     */
    @PostMapping("/rsqs")
    public Map<String, Object> getRsqs(@RequestParam("date") String date) {
        try {
            return R.ok(200,"成功",tripService.getRsqs(date));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月15日 下午 02:51:27
     * @Description: 门票收入月报
     */
    @PostMapping("/mpMonth")
    public Map<String, Object> getMpMonth(@RequestParam("date") String date) {
        try {
            return R.ok(200,"成功",tripService.getMpMonth(date));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月15日 下午 03:20:25
     * @Description: 入境旅游者人数月报
     */
    @PostMapping("/rjrsMonth")
    public Map<String, Object> getRjrsMonth(@RequestParam("date") String date) {
        try {
            return R.ok(200,"成功",tripService.getRjrsMonth(date));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月15日 下午 03:20:25
     * @Description: 入境旅游者人数占比分析
     */
    @PostMapping("/rjrsCount")
    public Map<String, Object> getRjrsCount(@RequestParam("date") String date) {
        try {
            return R.ok(200,"成功",tripService.getRjrsCount(date));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月15日 下午 04:23:04
     * @Description: 示范区年度报表
     */
    @PostMapping("/sfq")
    public Map<String, Object> getSfq(@RequestParam("date") String date) {
        try {
            return R.ok(200,"成功",tripService.getSfq(date));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }


    /**
     * @Author: Wangcheny
     * @Date: 2021年04月15日 下午 07:03:17
     * @Description: 全市景区停车场数量统计
     */
    @PostMapping("/cwCount")
    public Map<String, Object> getCwCount() {
        try {
            return R.ok(200,"成功",tripService.getCwCount());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    @PostMapping("/gis")
    public Map<String, Object> getGis() {
        try {
            return R.ok(200,"成功",tripService.getGis());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }
}
