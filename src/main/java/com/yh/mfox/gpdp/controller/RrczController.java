package com.yh.mfox.gpdp.controller;

import com.yh.mfox.gpdp.service.RrczService;
import com.yh.mfox.gpdp.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author: Wangcheny
 * @date: 2021年04月10日 9:19
 * @Description: 人人持证
 */
@RestController
@RequestMapping("/rrcz")
public class RrczController {

    @Autowired
    private RrczService rrczService;

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月10日 下午 03:02:24
     * @Description: 户籍地址分析 residenceAddr
     */
    @PostMapping("/ra")
    public Map<String, Object> getResidenceAddr(HttpServletRequest request){
        try {
            return R.ok(200,"成功", rrczService.getResidenceAddr());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }
    /**
     * @Author: Wangcheny
     * @Date: 2021年04月10日 下午 03:06:28
     * @Description: 户口分析
     */
    @PostMapping("/residence")
    public Map<String, Object> getResidence(HttpServletRequest request){
        try {
            return R.ok(200,"成功", rrczService.getResidence());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月10日 下午 05:47:54
     * @Description:  统计信息
     */
    @PostMapping("/count")
    public Map<String, Object> getCount(HttpServletRequest request){
        try {
            return R.ok(200,"成功", rrczService.getCount());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月10日 下午 05:47:54
     * @Description:  专业技术
     */
    @PostMapping("/profess")
    public Map<String, Object> getProfess(HttpServletRequest request){
        try {
            return R.ok(200,"成功", rrczService.getProfess());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月10日 下午 07:30:10
     * @Description: 职业技能
     */
    @PostMapping("/vocat")
    public Map<String, Object> getVocation(HttpServletRequest request){
        try {
            return R.ok(200,"成功", rrczService.getVocation());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    /**
     * @Author: Wangcheny
     * @Date: 2021年04月10日 下午 07:53:02
     * @Description: 持证人数
     */
    @PostMapping("/cz")
    public Map<String, Object> getCz(HttpServletRequest request){
        try {
            return R.ok(200,"成功", rrczService.getCz());
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }

    @PostMapping("/sbcx")
    public Map<String,Object> querySbcx(@RequestParam(name = "name") String name,@RequestParam(name = "idCard")String idCard){
        try {
            if("".equals(name) || "".equals(idCard)) return R.ok(202,"信息填写不完整，请重新输入","");
            Map<String, Object> map = rrczService.querySbcx(name, idCard);
            if(map == null){
                return R.ok(201,"实名信息未通过，请重新输入","");
            }else {
                return R.ok(200,"成功",map);
            }
        } catch (Exception e) {
            return R.error(400,"失败");
        }
    }
}
