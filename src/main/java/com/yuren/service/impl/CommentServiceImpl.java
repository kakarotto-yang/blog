package com.yuren.service.impl;


import com.yuren.mapper.CommentMapper;
import com.yuren.pojo.Comment;
import com.yuren.pojo.Topic;
import com.yuren.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> getCommentList(Topic topic) {
        return commentMapper.getCommentList(topic.getId());
    }

    public Comment getCommentById(int commentId) {
        return commentMapper.getCommentById(commentId);
    }

    public void addComment(Comment comment) {
        commentMapper.addComment(comment.getContent(),comment.getCommentDate(),comment.getTopic().getId(),comment.getAuthor().getId());
    }

    public List<Comment> getLatestComment(Integer id) {
        return commentMapper.getLatestComment(id);
    }

    public Integer delComment(Integer commentId) {

        return commentMapper.delComment(commentId);
    }


}
