package com.yuren.service.impl;

import com.yuren.mapper.UserMapper;
import com.yuren.pojo.User;
import com.yuren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

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

    public User login(String nickName, String password) {
        return userMapper.login(nickName,password);
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
