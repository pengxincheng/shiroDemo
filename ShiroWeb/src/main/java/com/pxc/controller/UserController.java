package com.pxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pxc on 2017/10/24.
 */
@Controller
public class UserController {

    @RequestMapping("userLogin")
    public String login(String username,String password){

        return "index.jsp";
    }
}
