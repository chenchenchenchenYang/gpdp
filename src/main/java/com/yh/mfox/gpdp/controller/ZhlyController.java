package com.yh.mfox.gpdp.controller;

import com.yh.mfox.gpdp.service.ZhlyService;
import com.yh.mfox.gpdp.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: Wangcheny
 * @Date: 2021年04月17日 下午 03:08:12
 * @Description: 智慧林业
 */
@RestController
@RequestMapping("/zhly")
public class ZhlyController {

    @Autowired
    private ZhlyService zhlyService;

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月17日 下午 03:52:18
     * @Description: 林业信息资源统计
     */
    @PostMapping("/count")
    public Map<String, Object> getDtgl() {
        try {
            return R.ok(200,"成功",zhlyService.getCount());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月19日 上午 10:20:29
     * @Description: 火险等级占比
     */
    @PostMapping("/hxdjzb")
    public Map<String, Object> getHxdjzb() {
        try {
            return R.ok(200,"成功",zhlyService.getHxdjzb());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月19日 上午 10:40:21
     * @Description: 生物多样性
     */
    @PostMapping("/dyx")
    public Map<String, Object> getDyx() {
        try {
            return R.ok(200,"成功",zhlyService.getDyx());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月19日 上午 11:59:27
     * @Description: 护林防火物资
     */
    @PostMapping("/fhwz")
    public Map<String, Object> getFhwz() {
        try {
            return R.ok(200,"成功",zhlyService.getFhwz());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月19日 下午 03:31:59
     * @Description: 护林员列表
     */
    @PostMapping("/hly")
    public Map<String, Object> getHly(String name) {
        try {
            return R.ok(200,"成功",zhlyService.getHly(name));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月19日 下午 05:38:10
     * @Description: 驻防队伍信息
     */
    @PostMapping("/zfdw")
    public Map<String, Object> getZfdw(String dwmc) {
        try {
            return R.ok(200,"成功",zhlyService.getZfdw(dwmc));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月19日 下午 06:25:02
     * @Description: 装备详情
     */
    @PostMapping("/zbxq")
    public Map<String, Object> getZbxq(String dwmc,String zbmc) {
        try {
            if("".equals(dwmc)) return R.error(400,"请求参数错误");
            return R.ok(200,"成功",zhlyService.getZbxq(dwmc,zbmc));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月19日 下午 08:14:35
     * @Description: 林场基本信息统计
     */
    @PostMapping("/jbxx")
    public Map<String, Object> getJbxx(String lcmc) {
        try {
            return R.ok(200,"成功",zhlyService.getJbxx(lcmc));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }
    /**
     * @Author: Wangcheny
     * @Date: 2022年04月13日 上午 10:22:52
     * @Description: 森林覆盖率
     */
    @PostMapping("/slfgl")
    public Map<String, Object> getSlfgl() {
        try {
            return R.ok(200,"成功",zhlyService.getSlfgl());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2022年04月13日 上午 10:26:17
     * @Description: 国家公益林信息
     */
    @PostMapping("/gylxx")
    public Map<String, Object> getGylxx() {
        try {
            return R.ok(200,"成功",zhlyService.getGylxx());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

}
