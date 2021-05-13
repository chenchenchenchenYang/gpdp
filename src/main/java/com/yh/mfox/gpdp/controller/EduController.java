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
     * @Date: 2021年04月20日 下午 02:55:37
     * @Description: 教师学历分布
     */
    @PostMapping("/xlfb")
    public Map<String, Object> getXlfb() {
        try {
            return R.ok(200,"成功",eduService.getXlfb());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月20日 下午 04:27:55
     * @Description: 教师毕业院校统计
     */
    @PostMapping("/byyx")
    public Map<String, Object> getByyx() {
        try {
            return R.ok(200,"成功",eduService.getByyx());
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

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月21日 上午 11:55:00
     * @Description: 在线学生人数情况
     */
    @PostMapping("/xsrs")
    public Map<String, Object> getXsrs(String date) {
        try {
            return R.ok(200,"成功",eduService.getXsrs(date));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月21日 上午 11:55:00
     * @Description: 年龄分布
     */
    @PostMapping("/nlfb")
    public Map<String, Object> getNlfb() {
        try {
            return R.ok(200,"成功",eduService.getNlfb());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月22日 下午 05:32:21
     * @Description: 外市户籍数量占比
     */
    @PostMapping("/hjsl")
    public Map<String, Object> getHjsl() {
        try {
            return R.ok(200,"成功",eduService.getHjsl());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月28日 下午 03:57:11
     * @Description: 中小学户口所在地
     */
    @PostMapping("/hkszd")
    public Map<String, Object> getHkszd() {
        try {
            return R.ok(200,"成功",eduService.getHkszd());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月28日 下午 04:21:47
     * @Description: 在编教师工作经验
     */
    @PostMapping("/gzjy")
    public Map<String, Object> getGzjy() {
        try {
            return R.ok(200,"成功",eduService.getGzjy());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月28日 下午 05:08:51
     * @Description: 年级分布
     */
    @PostMapping("/njfb")
    public Map<String, Object> getNjfb() {
        try {
            return R.ok(200,"成功",eduService.getNjfb());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年05月13日 下午 05:08:51
     * @Description: 中小学户籍统计
     */
    @PostMapping("/hjtj")
    public Map<String, Object> getHjtj() {
        try {
            return R.ok(200,"成功",eduService.getHjtj());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

}
