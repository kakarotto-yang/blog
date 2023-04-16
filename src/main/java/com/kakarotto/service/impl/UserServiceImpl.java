package com.kakarotto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kakarotto.common.result.Result;
import com.kakarotto.common.result.ResultCodeEnum;
import com.kakarotto.common.util.JwtUtil;
import com.kakarotto.common.util.RedisUtil;
import com.kakarotto.mapper.UserMapper;
import com.kakarotto.pojo.LoginUser;
import com.kakarotto.pojo.User;
import com.kakarotto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Resource
    private UserMapper userMapper;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisUtil redisCache;

    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }


    public User getUser(String nickName) {
        User User = userMapper.getUser(nickName);
        return User;
    }

    public void addUser(String nickName, String email, String webstation,String headImg) {
        userMapper.addUser(nickName,email,webstation,headImg);
    }

    public User getAdUserById(int id) {
        return userMapper.getAdUserById(id);
    }

    public User getSuperAdUser(){
        return userMapper.getSuperAdUser();
    }

    public User getAdUserByNickName(String user) {
        return userMapper.getAdUserByNickName(user);
    }
}
