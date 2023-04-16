package com.kakarotto.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleTag {
    private Integer id;         // ID
    private Integer articleId;  // 文章ID
    private Integer tagId;      // 标签ID
    private Date createTime;  // 创建时间
    private Date updateTime;  // 更新时间

    // getter和setter方法省略
}
