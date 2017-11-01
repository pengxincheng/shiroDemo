package com.pxc.user.controller;

import com.pxc.user.po.UserEntity;
import com.pxc.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by pxc on 2017/10/24.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("userLogin")
    public String login(String username,String password){

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                System.out.println("1. " + token.hashCode());
                // 执行登录.
                currentUser.login(token);
            }
            // 所有认证时异常的父类.
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
                System.out.println("登录失败: " + ae.getMessage());
            }
        }
        return "redirect:/index.jsp";
    }

    @RequestMapping("addUser")
    public String login(UserEntity user){
       try {
           userService.saveUser(user);
           return "login.jsp";
       }catch (Exception e){
           e.printStackTrace();
           return "403.jsp";
       }
    }
}
