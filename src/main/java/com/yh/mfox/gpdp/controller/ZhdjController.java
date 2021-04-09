package com.yh.mfox.gpdp.controller;

import com.yh.mfox.gpdp.service.ZhdjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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
    ZhdjService dljgService;

    @RequestMapping("/dljg")
    public Map<String, Object> getUserList(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Map<String, Object>> all = dljgService.getDljgAll();
            map.put("data", all);
            map.put("msg", "成功");
            map.put("code", "200");
            return map;
        } catch (Exception e) {
            map.put("code", 400);
            map.put("msg", "失败");
            return map;
        }
    }
}
