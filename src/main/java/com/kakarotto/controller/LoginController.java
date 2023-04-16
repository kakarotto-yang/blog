package com.kakarotto.controller;

import com.kakarotto.common.result.Result;
import com.kakarotto.pojo.User;
import com.kakarotto.service.LoginServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginServcie loginServcie;

    @PostMapping("/login")
    public Result login(User user){
        Result result = loginServcie.login(user);
        return result;
    }
}
