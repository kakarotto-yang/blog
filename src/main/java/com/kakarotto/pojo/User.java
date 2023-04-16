package com.kakarotto.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "user")
public class User {
    @TableId
    private Integer id ;
    @TableField
    private String nickName ;
    @TableField
    private String headImg ;
    @TableField
    private String email;
    @TableField
    private String webstation;
    @TableField
    private String password;
    @TableField
    private String isSuper;
    @TableField
    private String isAdmin;
    @TableField(exist = false)
    private List<Topic> topicList ;
}
