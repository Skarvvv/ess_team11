package com.team11.controller;

import com.team11.service.UserService;
import com.team11.vo.UserVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@SessionAttributes("user")
@Api(value = "/login", tags = "Login接口")
public class LoginController {

    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

//    @RequestMapping("login")
    @PostMapping("login")
    @ResponseBody
    public HashMap<String,Object> login(@RequestParam String account, @RequestParam String upass){
        System.out.println("login -- "+account+" -- "+upass);
        HashMap<String,Object> result = new HashMap<>();
//        ModelAndView mv = new ModelAndView();
        UserVO user = service.selectOne(account);
        if (user != null && user.getUpass().equals(upass)){
//            mv.addObject("msg",1);
//            mv.addObject("user",user);
            result.put("user",user);
            result.put("msg",1);
        }else {
//            mv.addObject("msg",0);
            result.put("msg",0);
        }
//        return mv;
        return result;
    }

//    @RequestMapping("sendMail")
//    @ResponseBody
//    public String sendMail() throws MessagingException {
//        //1.向SpringBeanFactory请求一个对象
//        BeanFactory context = new ClassPathXmlApplicationContext("classpath:config.xml");
//        JavaMailSender sender = (JavaMailSender) context.getBean("sender"); //JavaMailSenderImpl
//        //2.利用sender对象创建一个邮件对象
//        MimeMessage message = sender.createMimeMessage();
//        //3.发送邮件 --- 找其他类帮忙
//        MimeMessageHelper helper = new MimeMessageHelper(message); //是Session和Transport的结合
//        //4.需要告知helper 发给谁 以及发送的内容
//        helper.setFrom("1403724251@qq.com"); //设置发件人
//        helper.setTo("2367569086@qq.com"); //设置收件人
//        helper.setSubject("这是基于Spring的邮件主题"); //设置邮件主题
//        helper.setText("这是基于Spring的邮件内容"); //设置邮件内容
//        //5.直接发送消息
//        sender.send(message);
//
//        System.out.println("基于Spring的邮件 发送成功");
//        return "1";
//    }

}
