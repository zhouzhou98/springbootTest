package com.fly.bills.web.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fly.bills.domain.User;
import com.fly.bills.service.IUserService;
import com.fly.bills.util.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 老雷
 * @since 2020-02-09
 */
@Controller
@RequestMapping("login")
public class UserController {
    @Autowired
    private IUserService userService;
    /**
     * 跳转到登录页面
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("login")
    @ResponseBody
    public ResultObj login(String loginname, String code,String pwd, HttpSession session){
        String codeSession=session.getAttribute("code").toString();
        if(code!=null&&code.equals(codeSession)){
            QueryWrapper<User> wrapper=new QueryWrapper<>();
            wrapper.eq("loginname",loginname);
            wrapper.eq("pwd",pwd);
            User user = userService.getOne(wrapper);
            if(user!=null){
                return new ResultObj(200,"登录成功");
            }else {
                return new ResultObj(-1,"用户名或密码不正确");
            }
        }else {
            return new ResultObj(-1,"验证码输入错误");
        }

    }


    @RequestMapping("getCode")
    public void getCode(HttpServletResponse resp,HttpSession session) throws Exception {
        CircleCaptcha circleCaptcha=CaptchaUtil.createCircleCaptcha(116,36,4,5);
        String code = circleCaptcha.getCode();
//        植入session
        session.setAttribute("code",code);
        ServletOutputStream outputStream=resp.getOutputStream();
//        BufferedImage image = circleCaptcha.getImage();
        circleCaptcha.write(outputStream);
        outputStream.close();
    }
}

