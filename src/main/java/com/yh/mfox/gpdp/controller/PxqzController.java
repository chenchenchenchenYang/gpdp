package com.yh.mfox.gpdp.controller;

import com.yh.mfox.gpdp.service.PxqzService;
import com.yh.mfox.gpdp.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月09日 9:09
 * @Description: 培训求职
 */
@RestController
@RequestMapping("/pxqz")
public class PxqzController {
    @Autowired
    private PxqzService pxqzService;

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月09日 上午 11:02:23
     * @Description: 统计
     */
    @PostMapping("/count")
    public Map<String, Object> getCount(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",pxqzService.getCount());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月11日 上午 11:35:28
     * @Description: 人员信息
     */
    @PostMapping("/ryInfo")
    public Map<String, Object> getRyInfo(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",pxqzService.getRyInfo());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月12日 上午 09:18:41
     * @Description: 培训工种统计
     */
    @PostMapping("/gzCount")
    public Map<String, Object> getGzCount(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",pxqzService.getGzCount());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月12日 上午 10:29:31
     * @Description: 性别统计
     */
    @PostMapping("/xbCount")
    public Map<String, Object> getXbCount(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",pxqzService.getXbCount());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月12日 下午 02:35:42
     * @Description: 培训统计
     */
    @PostMapping("/pxInfo")
    public Map<String, Object> getPxInfo(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",pxqzService.getPxInfo());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月12日 下午 02:35:42
     * @Description: 求职信息
     */
    @PostMapping("/qzInfo")
    public Map<String, Object> getQzInfo(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",pxqzService.getQzInfo());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年05月06日 下午 03:02:27
     * @Description: 新需求-培训技能工种人员信息
     */
    @PostMapping("/ryInfoNew")
    public Map<String, Object> getRyInfoNew(HttpServletRequest request) {
        try {
            return R.ok(200,"成功",pxqzService.getRyInfoNew());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }
}
