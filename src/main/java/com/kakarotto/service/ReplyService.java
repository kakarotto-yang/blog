package com.kakarotto.service;



import com.kakarotto.pojo.Comment;
import com.kakarotto.pojo.Reply;

import java.util.List;

public interface ReplyService {
    List<Reply> getReplyList(Comment comment);
    void addReply(Reply reply);

    Integer delReply(Integer replyId);
}
