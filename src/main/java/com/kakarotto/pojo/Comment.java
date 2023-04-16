package com.kakarotto.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Comment {
    private Integer id;         // 评论ID
    private Integer userId;     // 评论用户ID
    private Integer articleId;  // 评论文章ID
    private Integer parentId;   // 父评论ID
    private String content;     // 评论内容
    private Date createTime;    // 创建时间
    private Date updateTime;    // 更新时间
}
