package com.kakarotto.service;


import com.kakarotto.pojo.Comment;
import com.kakarotto.pojo.Topic;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentList(Topic topic);
    Comment getCommentById(int commentId);
    void addComment(Comment comment);
    List<Comment> getLatestComment(Integer id);
    Integer delComment(Integer commentId);
}
