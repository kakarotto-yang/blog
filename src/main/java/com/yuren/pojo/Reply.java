package com.yuren.pojo;

import java.util.Date;

public class Reply {
    private Integer id ;
    private String content ;
    private Date replyDate ;
    private User author ;  //M:1
    private Comment comment ;       //M:1
    private User replyPerson;

    public Reply(){}
    public Reply(String content, Date replyDate, User author, Comment comment, User replyPerson){
        this.content=content;
        this.comment=comment;
        this.replyDate=replyDate;
        this.author=author;
        this.replyPerson=replyPerson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getReplyPerson() {
        return replyPerson;
    }

    public void setReplyPerson(User replyPerson) {
        this.replyPerson = replyPerson;
    }
}
