package com.yuren.service;



import com.yuren.pojo.Comment;
import com.yuren.pojo.Reply;

import java.util.List;

public interface ReplyService {
    List<Reply> getReplyList(Comment comment);
    void addReply(Reply reply);

    Integer delReply(Integer replyId);
}
