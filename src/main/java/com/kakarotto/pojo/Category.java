package com.kakarotto.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Category {
    private Integer id;             // 分类ID
    private String name;            // 分类名称
    private String parentId;       //父类
    private String description;     // 分类描述
    private Date createTime;        // 创建时间
    private Date updateTime;        // 更新时间
}

