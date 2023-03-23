package com.kakarotto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kakarotto.mapper.ReplyMapper;
import com.kakarotto.pojo.Comment;
import com.kakarotto.pojo.Reply;
import com.kakarotto.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper,Reply> implements ReplyService {



    public List<Reply> getReplyList(Comment comment) {
        QueryWrapper<Reply> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("comment",comment.getId());
        return baseMapper.selectList(queryWrapper);
    }


    public void addReply(Reply reply) {
        baseMapper.insert(reply);
    }

    public Integer delReply(Integer replyId) {
        return baseMapper.deleteById(replyId);
    }


}
