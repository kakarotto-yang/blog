package com.yuren.service.impl;

import com.yuren.mapper.ReplyMapper;
import com.yuren.pojo.Comment;
import com.yuren.pojo.Reply;
import com.yuren.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    public List<Reply> getReplyList(Comment comment) {
        return replyMapper.getReplyList(comment.getId());
    }


    public void addReply(Reply reply) {
        replyMapper.addReply(reply.getContent(),reply.getComment().getId(),reply.getReplyDate(),reply.getAuthor().getId(),reply.getReplyPerson().getId());
    }

    public Integer delReply(Integer replyId) {
        return replyMapper.delReply(replyId);
    }


}
