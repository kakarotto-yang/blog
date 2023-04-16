package com.kakarotto.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kakarotto.mapper.CommentMapper;
import com.kakarotto.pojo.Comment;
import com.kakarotto.pojo.Topic;
import com.kakarotto.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl extends ServiceImpl<CommentMapper,Comment> implements CommentService {
    @Resource
    CommentMapper commentMapper;
    public List<Comment> getCommentList(Topic topic) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("topic",topic.getId());
        List<Comment> commentList = baseMapper.selectList(queryWrapper);
        return commentList;
    }

    public Comment getCommentById(int commentId) {
        return baseMapper.selectById(commentId);
    }

    public void addComment(Comment comment) {
        baseMapper.insert(comment);
    }

    public List<Comment> getLatestComment(Integer id) {
        return commentMapper.getLatestComment(id);
    }

    public Integer delComment(Integer commentId) {
        return baseMapper.delComment(commentId);
    }

    @Override
    public List<Comment> getCommentByArticleId(int id) {
        List<Comment> commentList = baseMapper.selectList(new QueryWrapper<Comment>().eq("article_id",id));
        return commentList;
    }

    @Override
    public void batchDeleteComment(List<Comment> commentList) {
        baseMapper.deleteBatchIds(commentList);
    }


}
