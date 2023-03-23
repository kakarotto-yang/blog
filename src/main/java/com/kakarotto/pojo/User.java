package com.kakarotto.pojo;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id ;
    private String nickName ;
    private String headImg ;
    private String email;
    private String webstation;
    private String password;
    private String isSuper;
    private String isAdmin;
    private List<Topic> topicList ;
}
