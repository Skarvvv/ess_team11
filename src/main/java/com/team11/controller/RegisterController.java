package com.team11.controller;

import com.team11.domain.User;
import com.team11.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Api(value = "/register", tags = "Register接口")
public class RegisterController {

    @Autowired
    private UserService userService;

//    @RequestMapping("register")
    @PostMapping("register")
    @ResponseBody
    public int register(User user){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("index.jsp");
//        User user = new User();
//        user.setUname(username);
//        user.setUpass(password);
        int msg = userService.register(user);
//        mv.addObject("msg",msg);
        return msg;
    }

//    @PostMapping("messageUpdate")
//    @ResponseBody
//    public int messageUpdate(User user){
//        return userService.messageUpdate(user);
//    }

}
