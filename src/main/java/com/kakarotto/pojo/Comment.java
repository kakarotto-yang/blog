package com.kakarotto.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Comment {
    private Integer id ;
    private String content ;
    private Date commentDate ;
    private User author ; //M:1
    private Topic topic ;   //1:1
    private List<Reply> replyList;//1:m
}
