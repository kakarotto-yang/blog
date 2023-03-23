package com.kakarotto.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Reply {
    private Integer id ;
    private String content ;
    private Date replyDate ;
    private User author ;  //M:1
    private Comment comment ;       //M:1
    private User replyPerson;
}
