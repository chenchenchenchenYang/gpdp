package com.yh.mfox.gpdp.controller;

import com.yh.mfox.gpdp.service.CommonService;
import com.yh.mfox.gpdp.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月20日 20:01
 * @Description: 公共资源
 */
@RestController
@RequestMapping("/common")
public class CommonController {
    @Autowired
    private CommonService commonService;

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月20日 下午 08:21:06
     * @Description: 分页获取视频
     */
    @PostMapping("/sp")
    public Map<String,Object> getSp(int page,int size, String yj,String ej,String sj){
        try {
            return R.ok(200,"成功",commonService.getSp(page,size,yj,ej,sj));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * 获取视频分类
     *
     * @return
     */
    @PostMapping("/spType")
    public Map<String,Object> spType(){
        try {
            return R.ok(200,"成功",commonService.getSpType());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * 视频初始化树形结构
     *
     * @return
     */
    @PostMapping("/spInit")
    public Map<String,Object> spInit(){
        try {
            return R.ok(200,"成功",commonService.spInit());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    @PostMapping("/queryNode")
    public Map<String,Object> queryNode(int resourceId){
        try {
            return R.ok(200,"成功",commonService.queryNode(resourceId));
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }
}
