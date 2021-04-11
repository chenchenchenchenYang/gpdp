package com.yh.mfox.gpdp.controller;

import com.yh.mfox.gpdp.service.ZhdjService;
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
 * @Description: 党龄结构
 */
@RestController
@RequestMapping("/zhdj")
public class ZhdjController {
    @Autowired
    private ZhdjService dljgService;

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月09日 上午 11:02:23
     * @Description: 党龄结构
     */
    @PostMapping("/dljg")
    public Map<String, Object> getDljgAll(HttpServletRequest request) {
        try {
            return R.ok(200, "成功", dljgService.getDljgAll());
        } catch (Exception e) {
            return R.error(400, "失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月09日 上午 11:04:21
     * @Description: 党建风采
     */
    @PostMapping("/djfc")
    public Map<String, Object> getDjfc(HttpServletRequest request) {
        try {
            return R.ok(200, "成功", dljgService.getDjfcByType());
        } catch (Exception e) {
            return R.error(400, "失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月09日 上午 11:04:21
     * @Description: 党员学历
     */
    @PostMapping("/dyxl")
    public Map<String, Object> getDyxl(HttpServletRequest request) {
        try {
            return R.ok(200, "成功", dljgService.getDyxl());
        } catch (Exception e) {
            return R.error(400, "失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月09日 下午 02:43:58
     * @Description:党员性别
     */
    @PostMapping("/dyxb")
    public Map<String, Object> getDyxb(HttpServletRequest request) {
        try {
            return R.ok(200, "成功", dljgService.getDyxb());
        } catch (Exception e) {
            return R.error(400, "失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月09日 下午 03:44:31
     * @Description: 党员基本情况
     */
    @PostMapping("/dyjbqk")
    public Map<String, Object> getDyjbqk(HttpServletRequest request) {
        try {
            return R.ok(200, "成功", dljgService.getDyjbqk());
        } catch (Exception e) {
            return R.error(400, "失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月09日 下午 04:12:30
     * @Description: 党员风采
     */
    @PostMapping("/dyfc")
    public Map<String, Object> getDyfc(HttpServletRequest request) {
        try {
            return R.ok(200, "成功", dljgService.getDyfc());
        } catch (Exception e) {
            return R.error(400, "失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月09日 下午 04:15:41
     * @Description: 道德模范
     */
    @PostMapping("/ddmf")
    public Map<String, Object> getDdmf(HttpServletRequest request) {
        try {
            return R.ok(200, "成功", dljgService.getDdmf());
        } catch (Exception e) {
            return R.error(400, "失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月09日 下午 04:23:34
     * @Description: 党员年龄结构
     */
    @PostMapping("/dynljg")
    public Map<String, Object> getDynljg(HttpServletRequest request) {
        try {
            return R.ok(200, "成功", dljgService.getDynljg());
        } catch (Exception e) {
            return R.error(400, "失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月09日 下午 04:24:54
     * @Description: 发展党员情况
     */
    @PostMapping("/fzdyqk")
    public Map<String, Object> getFzdyqk(HttpServletRequest request) {
        try {
            return R.ok(200, "成功", dljgService.getFzdyqk());
        } catch (Exception e) {
            return R.error(400, "失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月09日 下午 04:24:54
     * @Description: 组织先锋榜
     */
    @PostMapping("/zzxfb")
    public Map<String, Object> getZzxfb(HttpServletRequest request) {
        try {
            return R.ok(200, "成功", dljgService.getZzxfb());
        } catch (Exception e) {
            return R.error(400, "失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月09日 下午 04:37:27
     * @Description: 热门关键词
     */
    @PostMapping("/rmgjc")
    public Map<String, Object> getRmgjc(HttpServletRequest request) {
        try {
            return R.ok(200, "成功", dljgService.getRmgjc());
        } catch (Exception e) {
            return R.error(400, "失败");
        }
    }


    /**
     * @Author: Wangcheny
     * @Date: 2021年04月09日 下午 04:49:46
     * @Description: 三会一课
     */
    @PostMapping("/shyk")
    public Map<String, Object> getShyk(HttpServletRequest request) {
        try {
            return R.ok(200, "成功", dljgService.getShyk());
        } catch (Exception e) {
            return R.error(400, "失败");
        }
    }

    @PostMapping("/zyzhd")
    public Map<String, Object> getZyzhd(HttpServletRequest request) {
        try {
            return R.ok(200, "成功", dljgService.getZyzhd());
        } catch (Exception e) {
            return R.error(400, "失败");
        }
    }

}
