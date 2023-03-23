package com.yuren.pojo;

public class TmpTopic {
    private Integer id;
    private String content;
    private User author;

    public TmpTopic() {
    }

    public TmpTopic(Integer id, String content, User author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "TmpTopic{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author=" + author +
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
