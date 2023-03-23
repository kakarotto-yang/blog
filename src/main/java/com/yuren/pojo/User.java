package com.yuren.pojo;

import java.util.List;

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

    public User() {
    }

    public User(Integer id, String nickName, String headImg, String email, String webstation, String password, String isSuper, String isAdmin, List<Topic> topicList) {
        this.id = id;
        this.nickName = nickName;
        this.headImg = headImg;
        this.email = email;
        this.webstation = webstation;
        this.password = password;
        this.isSuper = isSuper;
        this.isAdmin = isAdmin;
        this.topicList = topicList;
    }

    @Override
    public String toString() {
        return "UserController{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", headImg='" + headImg + '\'' +
                ", email='" + email + '\'' +
                ", webstation='" + webstation + '\'' +
                ", password='" + password + '\'' +
                ", isSuper='" + isSuper + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                ", topicList=" + topicList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebstation() {
        return webstation;
    }

    public void setWebstation(String webstation) {
        this.webstation = webstation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(String isSuper) {
        this.isSuper = isSuper;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }
}
