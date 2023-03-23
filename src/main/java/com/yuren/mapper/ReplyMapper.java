package com.yuren.mapper;

import com.yuren.pojo.Reply;

import java.util.Date;
import java.util.List;

public interface ReplyMapper {
    //获取指定评论的回复列表
    List<Reply> getReplyList(Integer commentId);
    //添加回复
    void addReply(String content, Integer comment, Date replyDate, Integer author, Integer replyPerson);
    //删除回复
    Integer delReply(Integer id);
}
