package com.yuren.service;


import com.yuren.pojo.User;

public interface UserService {
   User getUserById(Integer id);
   User getUser(String nickName);
   void addUser(String nickName,String email,String webstation,String headImg);
   User login(String nickName, String password);

   User getAdUserById(int id);

   User getSuperAdUser();

   User getAdUserByNickName(String user);
}
