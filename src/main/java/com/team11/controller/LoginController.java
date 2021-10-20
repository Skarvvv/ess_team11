package com.team11.controller;

import com.team11.domain.User;
import com.team11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class LoginController {

    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @RequestMapping("login")
    public ModelAndView login(String account,String upass){
        ModelAndView mv = new ModelAndView();
        User user = service.selectOne(account);
        if (user != null && user.getUpass().equals(upass)){
            mv.setViewName("welcome.jsp");
            mv.addObject("user",user);
        }else {
            mv.setViewName("index.jsp");
            mv.addObject("msg","账号或密码错误");
        }
        return mv;
    }

}
