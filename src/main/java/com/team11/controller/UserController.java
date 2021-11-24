package com.team11.controller;

import com.team11.domain.User;
import com.team11.service.UserService;
import com.team11.vo.UserVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@SessionAttributes("user")
@Api(value = "/login", tags = "UserController")
public class UserController {

    @Autowired
    private UserService service;

    //    @RequestMapping("login")
    @PostMapping("login")
//    @ResponseBody
    public HashMap<String,Object> login(@RequestParam String account, @RequestParam String upass){
//    public ModelAndView login(@RequestParam String account, @RequestParam String upass){
        System.out.println("login -- "+account+" -- "+upass);
        HashMap<String,Object> result = new HashMap<>();
//        ModelAndView mv = new ModelAndView();
        UserVO user = service.selectOne(account);
        if (user != null && user.getUpass().equals(upass)){
//            mv.addObject("msg",1);
//            mv.addObject("user",user);
//            mv.setViewName("welcome.jsp");
            result.put("user",user);
            result.put("msg",1);
        }else {
//            mv.addObject("msg",0);
            result.put("msg",0);
        }
//        return mv;
        return result;
    }

    @Autowired
    private UserService userService;

    //    @RequestMapping("register")
    @PostMapping("register")
//    @ResponseBody
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

    @PostMapping("messageUpdate")
    @ResponseBody
    public int messageUpdate(User user){
        return userService.messageUpdate(user);
    }

}
