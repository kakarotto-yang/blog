package com.yuren.service;


import com.yuren.pojo.Comment;
import com.yuren.pojo.Topic;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentList(Topic topic);
    Comment getCommentById(int commentId);
    void addComment(Comment comment);
    List<Comment> getLatestComment(Integer id);
    Integer delComment(Integer commentId);
}
