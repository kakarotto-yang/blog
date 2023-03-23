package com.yuren.pojo;

import java.util.Date;
import java.util.List;

public class Comment {
    private Integer id ;
    private String content ;
    private Date commentDate ;
    private User author ; //M:1
    private Topic topic ;   //1:1
    private List<Reply> replyList;//1:m

    public Comment(){}

    public Comment(Integer id, String content, Date commentDate, User author, Topic topic, List<Reply> replyList) {
        this.id = id;
        this.content = content;
        this.commentDate = commentDate;
        this.author = author;
        this.topic = topic;
        this.replyList = replyList;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", commentDate=" + commentDate +
                ", author=" + author +
                ", topic=" + topic +
                ", replyList=" + replyList +
                '}';
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

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }
}
