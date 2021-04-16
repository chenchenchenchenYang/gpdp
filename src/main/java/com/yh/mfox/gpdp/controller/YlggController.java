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

    @PostMapping("/srCount")
    public Map<String, Object> getSrCount(String type,String date) {
        try {
            return R.ok(200,"成功",ylggService.getSrCount(type,date));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

}
