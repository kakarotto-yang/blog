package com.kakarotto.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Topic {
    private Integer id;
    private String title;
    private String content;
    private Date topicDate;
    private User author;          //M:1
    private String topicType;
    private Integer praise;
    private Integer views;
    private String priority;
    private String edtext;
    private List<Comment> commentList;     //1:N
}
