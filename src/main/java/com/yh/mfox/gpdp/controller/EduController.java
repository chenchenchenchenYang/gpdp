package com.yh.mfox.gpdp.controller;

import com.yh.mfox.gpdp.service.EduService;
import com.yh.mfox.gpdp.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: Wangcheny
 * @Date: 2021年04月20日 下午 02:30:29
 * @Description: 智慧教育
 */
@RestController
@RequestMapping("/edu")
public class EduController {
    @Autowired
    private EduService eduService;

    
    /**
     * @Author: Wangcheny
     * @Date: 2021年04月20日 下午 02:54:49
     * @Description: 高平市学校概况
     */
    @PostMapping("/count")
    public Map<String, Object> getCount() {
        try {
            return R.ok(200,"成功",eduService.getCount());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月20日 下午 02:55:37
     * @Description: 学校人数信息
     */
    @PostMapping("/info")
    public Map<String, Object> getInfo() {
        try {
            return R.ok(200,"成功",eduService.getInfo());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月20日 下午 04:27:55
     * @Description: 学校数量占比
     */
    @PostMapping("/xxzb")
    public Map<String, Object> getXxzb() {
        try {
            return R.ok(200,"成功",eduService.getXxzb());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月20日 下午 04:33:08
     * @Description: 全市学生性别比例
     */
    @PostMapping("/xbbl")
    public Map<String, Object> getXbbl(String date) {
        try {
            return R.ok(200,"成功",eduService.getXbbl(date));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月20日 下午 04:52:30
     * @Description: 全市教师性别占比
     */
    @PostMapping("/jszb")
    public Map<String, Object> getJszb() {
        try {
            return R.ok(200,"成功",eduService.getJszb());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月20日 下午 05:09:58
     * @Description: 学校类别，下拉查询选项
     */
    @PostMapping("/type")
    public Map<String, Object> getType() {
        try {
            return R.ok(200,"成功",eduService.getType());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月20日 下午 05:12:58
     * @Description: 学校基本信息表
     */
    @PostMapping("/base")
    public Map<String, Object> getBase(String type,String name) {
        try {
            return R.ok(200,"成功",eduService.getBase(type,name));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }
}
