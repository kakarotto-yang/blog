package com.kakarotto.service;


import com.kakarotto.common.result.Result;
import com.kakarotto.pojo.User;

public interface UserService {
   User getUserById(Integer id);
   User getUser(String nickName);
   void addUser(String nickName,String email,String webstation,String headImg);
   User getAdUserById(int id);
   User getSuperAdUser();
   User getAdUserByNickName(String user);
}
