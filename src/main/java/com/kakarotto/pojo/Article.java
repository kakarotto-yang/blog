package com.kakarotto.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("article")
public class Article {
    // 文章ID
    private int id;

    // 文章标题

    private String title;

    // 文章内容
    private String content;

    // 文章创建时间
    private Date createTime;

    // 文章作者
    private int author;

    // 文章分类
    private int category;

    // 点赞数
    private int likes;

    // 浏览数
    private int views;

    // 评论数
    private int comments;

    // 文章封面
    private String cover;

    // 文章状态，0表示未发布，1表示已发布
    @TableField("`status`")
    private int status;

    // 文章来源
    private String source;

    // 文章附件
    private String attachments;

    // 文章摘要
    private String summary;

    // 文章外链
    private String externalLink;

    // 文章排序
    @TableField("`order`")
    private int order;

    // 文章评论是否可用，0表示不可用，1表示可用
    private int commentEnabled;

    // 文章评论是否需要审核，0表示不需要，1表示需要
    private int commentPermission;

    // 文章更新时间
    private Date updateTime;
}

