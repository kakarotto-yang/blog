package com.kakarotto.controller;


import com.kakarotto.pojo.*;
import com.kakarotto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@PreAuthorize("hasRole('system:admin:add')")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService topicService;
    @Autowired
    private BlogService blogService;



//    @PostMapping(value = "/addComment")
//    public Map<String, String > addComment(Integer topicId, String content, String nickName, String email, String webstation,String headImg){
//        Topic topic = topicService.getTopicById(topicId);
//        //作者
//        User user =userService.getUser(nickName);
//        if (user ==null){
//            userService.addUser(nickName,email,webstation,headImg);
//            user =userService.getUser(nickName);
//        }
//        Comment comment=new Comment();
//        comment.setContent(content);
//        comment.setArticleId(topic);
//        comment.setAuthor(user);
//        commentService.addComment(comment);
//        BlogMsg blogMsg = blogService.getBlogMsg();
//        blogService.updateCommentNum(blogMsg.getCommentNum()+1);
//        Map<String, String > map = new HashMap<String, String >();
//        map.put("message","ok");
//        return map;
//    }
//    //获取最新评论
//    @GetMapping(value = "/getLatestComment")
//    public List<Comment> getLatestComment(String user) {
//        User author = null;
//        if(user.equals("")){
//            author = userService.getSuperAdUser();
//        }else {
//            author = userService.getAdUserByNickName(user);
//        }
//        List<Comment> latestComment = commentService.getLatestComment(author.getId());
//        return latestComment;
//    }
//
//    @PostMapping(value = "/delComment/{commentId}")
//    public Map<String, String > delComment(@PathVariable("commentId")Integer commentId){
//        Integer rows = commentService.delComment(commentId);
//        if(rows==1){
//            BlogMsg blogMsg = blogService.getBlogMsg();
//            blogService.updateCommentNum(blogMsg.getCommentNum()-1);
//        }
//
//        Map<String, String > map = new HashMap<String, String >();
//        map.put("code","1");
//        return map;
//    }
//

}
