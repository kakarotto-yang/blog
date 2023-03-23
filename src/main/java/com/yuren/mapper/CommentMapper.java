package com.yuren.mapper;

import com.yuren.pojo.Comment;

import java.util.Date;
import java.util.List;

public interface CommentMapper {
    List<Comment> getCommentList(Integer topicId);
    Comment getCommentById(int commentId);
    void addComment(String content, Date commentDate, Integer topic, Integer author);
    List<Comment> getLatestComment(Integer id);
    Integer delComment(Integer commentId);
}
