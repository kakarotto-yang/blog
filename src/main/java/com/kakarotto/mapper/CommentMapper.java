package com.kakarotto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kakarotto.pojo.Comment;

import java.util.Date;
import java.util.List;

public interface CommentMapper extends BaseMapper<Comment> {
    List<Comment> getLatestComment(Integer id);
    Integer delComment(Integer commentId);
}
