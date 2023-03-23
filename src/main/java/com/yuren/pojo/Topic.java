package com.yuren.pojo;

import java.util.Date;
import java.util.List;

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

    public Topic() {
    }

    public Topic(Integer id, String title, String content, Date topicDate, User author, String topicType, Integer praise, Integer views, String priority, String edtext, List<Comment> commentList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.topicDate = topicDate;
        this.author = author;
        this.topicType = topicType;
        this.praise = praise;
        this.views = views;
        this.priority = priority;
        this.edtext = edtext;
        this.commentList = commentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(Date topicDate) {
        this.topicDate = topicDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getEdtext() {
        return edtext;
    }

    public void setEdtext(String edtext) {
        this.edtext = edtext;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", topicDate=" + topicDate +
                ", author=" + author +
                ", topicType='" + topicType + '\'' +
                ", praise=" + praise +
                ", views=" + views +
                ", priority='" + priority + '\'' +
                ", edtext='" + edtext + '\'' +
                ", commentList=" + commentList +
                '}';
    }
}
