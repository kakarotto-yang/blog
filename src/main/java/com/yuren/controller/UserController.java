package com.yuren.controller;

import com.yuren.pojo.User;
import com.yuren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login")
    public Map<String,String> login(String nickName, String password){
        User User = userService.login(nickName,password);
        Map<String,String> json=new HashMap<String,String>();
        if (User!=null){
            json.put("token",nickName);
            json.put("message","登录成功！");
            json.put("status","1");
        }else{
            json.put("status","0");
            json.put("message","账号密码错误 or 无权访问");
        }
        return json;
    }

    //增加管理员

    @RequestMapping(value = "/addAdmin",method = RequestMethod.POST)
    public Map<String,String> addAdmin(String nickName, String password){
        User user = userService.login(nickName,password);
        Map<String,String> json=new HashMap<String,String>();
        if (user!=null && user.getIsSuper().equals('1')){

            json.put("token",nickName);
            json.put("status","ok");
        }else{
            json.put("status","err");
        }
        return json;
    }





}



