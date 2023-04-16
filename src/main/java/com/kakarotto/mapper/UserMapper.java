package com.kakarotto.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kakarotto.pojo.User;
import org.apache.ibatis.annotations.Mapper;

public interface UserMapper extends BaseMapper<User> {
    User getUserById(Integer id);
    User getUser(String nickName) ;
    void addUser(String nickName,String email,String webstation,String headImg);
    User login(String nickName, String password);
    User getAdUserById(int id);
    User getSuperAdUser();
    User getAdUserByNickName(String user);
}
