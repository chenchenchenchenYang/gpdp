package com.yh.mfox.gpdp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Wangcheny
 * @date: 2022年06月07日 16:08
 * @Description:
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
