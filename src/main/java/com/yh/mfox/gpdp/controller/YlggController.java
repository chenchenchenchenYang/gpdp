package com.yh.mfox.gpdp.controller;

import com.yh.mfox.gpdp.service.YlggService;
import com.yh.mfox.gpdp.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月12日 15:47
 * @Description: 智慧电梯
 */
@RestController
@RequestMapping("/ylgg")
public class YlggController {

    @Autowired
    private YlggService ylggService;

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月16日 上午 11:56:55
     * @Description: 门诊/急诊人数
     * @param : type day/week/month/year
     * @param : date 2021-01-01
     */
    @PostMapping("/rsCount")
    public Map<String, Object> getRsCount(String type,String date) {
        try {
            return R.ok(200,"成功",ylggService.getRsCount(type,date));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月16日 下午 05:31:40
     * @Description: 门诊/住院收入占比
     */
    @PostMapping("/srCount")
    public Map<String, Object> getSrCount(String type,String date) {
        try {
            return R.ok(200,"成功",ylggService.getSrCount(type,date));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月17日 上午 09:54:16
     * @Description: 手术及检查例数趋势图
     */
    @PostMapping("/ssjc")
    public Map<String, Object> getSsjc(String type,String date) {
        try {
            return R.ok(200,"成功",ylggService.getSsjc(type,date));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月17日 上午 09:57:33
     * @Description: 入院人数变化
     */
    @PostMapping("/ryrs")
    public Map<String, Object> getRyrs(String type,String date) {
        try {
            return R.ok(200,"成功",ylggService.getRyrs(type,date));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月17日 上午 10:41:23
     * @Description: 住院、门诊均次费
     */
    @PostMapping("/jcf")
    public Map<String, Object> getJcf(String type,String date) {
        try {
            return R.ok(200,"成功",ylggService.getJcf(type,date));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月19日 上午 09:57:03
     * @Description: 学历占比
     */
    @PostMapping("/xl")
    public Map<String, Object> getXl() {
        try {
            return R.ok(200,"成功",ylggService.getXl());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月19日 上午 09:57:03
     * @Description: 职称构成
     */
    @PostMapping("/zc")
    public Map<String, Object> getZc() {
        try {
            return R.ok(200,"成功",ylggService.getZc());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

}
