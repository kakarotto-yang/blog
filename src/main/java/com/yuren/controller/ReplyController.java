package com.yuren.controller;


import com.yuren.pojo.User;
import com.yuren.pojo.Blog;
import com.yuren.pojo.Comment;
import com.yuren.pojo.Reply;

import com.yuren.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ReplyController {
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ReplyService replyService;
    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/addReply")
    @ResponseBody
    public Map<String, String > addReply(String nickName, String email, String webstation, String content, Integer commentId, Integer replyPersonId, String headImg) {
        //作者replyPersonId
        User user =userService.getUser(nickName);
        if (user ==null){
            userService.addUser(nickName,email,webstation,headImg);
            user =userService.getUser(nickName);
        }
        //回复所属评论
        Comment comment = commentService.getCommentById(commentId);
        //回复人
        User replyPerson = userService.getUserById(replyPersonId);

        Reply reply = new Reply();
        reply.setContent(content);
        reply.setReplyDate(new Date());
        reply.setAuthor(user);
        reply.setComment(comment);
        reply.setReplyPerson(replyPerson);
        replyService.addReply(reply);
        Blog blog= blogService.getBlogMsg();
        blogService.updateCommentNum(blog.getCommentNum()+1);
        Map<String, String > map = new HashMap<String, String >();
        map.put("message","ok");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/delReply/{replyId}")
    public Map<String, String > delReply(@PathVariable("replyId")Integer replyId){
        Integer rows = replyService.delReply(replyId);
        if(rows==1){
            Blog blog= blogService.getBlogMsg();
            blogService.updateCommentNum(blog.getCommentNum()-1);
        }
        Map<String, String > map = new HashMap<String, String >();
        map.put("code","1");
        return map;
    }
}
