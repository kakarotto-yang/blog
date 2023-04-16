package com.kakarotto.controller.blogapi;


import com.kakarotto.common.annotation.RateLimit;
import com.kakarotto.common.result.Result;
import com.kakarotto.pojo.*;
import com.kakarotto.query.ArticleQueryVo;
import com.kakarotto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ArticleApi {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;
    @Autowired
    private ReplyService replyService;
    @Autowired
    private BlogService blogService;

    //根据分页条件和查询条件获取首页文章
    @PostMapping(value = "getArticlePage/{page}/{limit}")
    @RateLimit
    @Cacheable(value = "indexPage",key = "'Page:'+#page+'_'+#limit")
    public Result getArticlePage(@PathVariable int page,
                                      @PathVariable int limit,
                                      @RequestBody(required = false) ArticleQueryVo articleQueryVo) {
        Result result = articleService.selectArticlePage(page,limit,articleQueryVo);
        return result;
    }

//    //根据帖子类型获取帖子
//    @GetMapping(value = "/topicType/{topicType}")
//    public List<Topic> getTopicByType(@PathVariable("topicType") String topicType,String user) {
//        User author = null;
//        if(user.equals("")){
//            author = userService.getSuperAdUser();
//        }else {
//            author = userService.getAdUserByNickName(user);
//        }
//        List<Topic> topicList = articleService.getTopicByType(author.getId(),topicType);
//        return topicList;
//    }
//
//    //获取具体某id的帖子
//    @GetMapping(value = "/topic/detail/{topicId}")
//    public Topic topicDetail(@PathVariable("topicId") Integer topicId) {
//        Topic topic = articleService.getTopicById(topicId);
//        List<Comment> comments = commentService.getCommentList(topic);
//        //commentAccount评论总数量
//        Integer commentAccount = comments.size();
//        for (int i = 0; i < comments.size(); i++) {
//            //为每一条评论设置回复
//            Comment comment = comments.get(i);
//            List<Reply> replieList = replyService.getReplyList(comment);
//            commentAccount += replieList.size();
//            //设置回复的作者、收回复的人
//            for (int j = 0; j < replieList.size(); j++) {
//                Reply reply = replieList.get(j);
//                reply.setAuthor(userService.getUserById(reply.getAuthor().getId()));
//                reply.setReplyPerson(userService.getUserById(reply.getReplyPerson().getId()));
//            }
//            comment.setReplyList(replieList);
//            comment.setAuthor(userService.getUserById(comment.getAuthor().getId()));
//        }
//        //设置话题的评论
//        topic.setCommentList(comments);
//        articleService.updataViews(topic.getId(),topic.getViews()+1);
//        return topic;
//    }
//
//    //获取热门文章
//    @GetMapping(value = "/getHotEssay")
//    public List<Topic> getHotEssay(String user) {
//        User author = null;
//        if(user.equals("")){
//            author = userService.getSuperAdUser();
//        }else {
//            author = userService.getAdUserByNickName(user);
//        }
//        List<Topic> hotEssayList = articleService.getHotEssay(author.getId());
//        return hotEssayList;
//    }
//
//    //获取最新文章
//    @GetMapping(value = "/getLatestEssay")
//    public List<Topic> getLatestEssay(String user) {
//        User author = null;
//        if(user.equals("")){
//            author = userService.getSuperAdUser();
//        }else {
//            author = userService.getAdUserByNickName(user);
//        }
//        List<Topic> latestEssay = articleService.getLatestEssay(author.getId());
//        return latestEssay;
//    }
//
//    //点赞
//    @GetMapping(value = "/topic/praise")
//    public Map<String,String> addPraise(Integer id,String praiseType) {
//        Topic topic = articleService.getTopicById(id);
//        if (praiseType.equals("add")){
//            articleService.updataPraise(id,topic.getPraise()+1);
//        }else {
//            articleService.updataPraise(id,topic.getPraise() - 1);
//        }
//        Map<String,String> map=new HashMap<String,String>();
//        map.put("message","ok");
//        return map;
//    }
//
//    //处理上传图片
//    @PostMapping(value = "/uploadImg")
//    public Map<String,String> uploadImg(@RequestParam(value = "file", required = false) MultipartFile photo,String user,HttpSession session) throws IOException {
//         String fileName = photo.getOriginalFilename();
//        //处理文件重名问题
//         String qzName = fileName.substring(0,fileName.lastIndexOf("."));
//         fileName = UUID.randomUUID().toString() + fileName;
//         //获取服务器中photo目录的路径
//         ServletContext servletContext = session.getServletContext();
//         String photoPath = servletContext.getRealPath("photo/"+user);
//         File file = new File(photoPath);
//         if(!file.exists()){
//             file.mkdir();
//         }
//         if(user.equals("")){
//             User author = userService.getSuperAdUser();
//             user = author.getNickName();
//         }
//         String finalPath = photoPath + File.separator + fileName;
//         //实现上传功能
//         photo.transferTo(new File(finalPath));
//         Map<String,String> json=new HashMap<String,String>();
//         json.put("success","1");
//         json.put("desc",qzName);
//         json.put("url","/photo/"+user+'/'+fileName);
//         return json;
//    }
//
//    @GetMapping(value = "/loadTempAddTopic")
//    public TmpTopic loadTempAddTopic(String user){
//        User author = null;
//        if(user.equals("")){
//            author = userService.getSuperAdUser();
//        }else {
//            author = userService.getAdUserByNickName(user);
//        }
//        TmpTopic tmpTopic = tmparticleService.loadTempAddTopic(author.getId());
//        //如果没有临时文章就创建
//        if(tmpTopic == null){
//            tmparticleService.createTmpTopic(author.getId());
//            tmpTopic = tmparticleService.loadTempAddTopic(author.getId());
//        }
//
//        return tmpTopic;
//    }
//
//    @PostMapping(value = "/tmpSave")
//    public Map<String,String> saveTempAddTopic(String context,String user){
//        User author = null;
//        if(user.equals("")){
//            author = userService.getSuperAdUser();
//        }else {
//            author = userService.getAdUserByNickName(user);
//        }
//        String tmp = context;
//        tmp = tmp.replace("\r","");
//        tmp = tmp.replace("\n","");
//        tmp = tmp.replace(" ","");
//        if(tmp.equals("")){
//            context=tmp;
//        }
//        Integer rows = tmparticleService.tmpSave(author.getId(),context);
//        Map<String,String> map=new HashMap<String,String>();
//        if (rows != 0){
//            map.put("status","1");
//            map.put("message","保存成功！");
//        }else {
//            map.put("status","0");
//            map.put("message","保存失败！");
//        }
//        return map;
//    }
//    //处理添加帖子的内容，保存到服务器
//    @PostMapping(value = "/addTopic")
//    public Map<String,String> addTopic(String context,String priority,String user) {
//            String Title = context.substring(context.indexOf("#"), context.indexOf("\n"));
//            Title = Title.substring(Title.lastIndexOf("#") + 1);
//            Title.trim();
//            Title = Title.replace("\r","");
//            String topicType = context.substring(context.indexOf("星期") + 5, context.indexOf("星期") + 7);
//            String time = context.substring(context.indexOf(")|") + 2, context.indexOf(")|") + 21);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date topicDate = new Date();
//            try {
//                topicDate = sdf.parse(time);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            Topic topic = new Topic();
//
//            User author = null;
//            if(user.equals("")){
//                author = userService.getSuperAdUser();
//            }else {
//                author = userService.getAdUserByNickName(user);
//            }
//            topic.setAuthor(author);
//            topic.setTopicType(topicType);
//            topic.setTopicDate(topicDate);
//            topic.setContent(context);
//            topic.setTitle(Title);
//            topic.setPriority(priority);
//            articleService.addTopic(topic);
//            BlogMsg blogMsg = blogService.getBlogMsg();
//            blogService.updateEssayNum(blogMsg.getEssayNum()+1);
//            Map<String,String> map=new HashMap<String,String>();
//            map.put("message","ok");
//            return map;
//    }
//
//    //前端定时保存编辑数据
//    @PostMapping(value = "/editSave/{topicId}")
//    public Map<String,String> editSave(String context, @PathVariable("topicId")Integer topicId){
//        Topic topic = articleService.getTopicById(topicId);
//        topic.setEdtext(context);
//        Integer rows = articleService.editSave(topic);
//        Map<String,String> map=new HashMap<String,String>();
//        if (rows != 0){
//            map.put("status","1");
//            map.put("message","保存成功！");
//        }else {
//            map.put("status","0");
//            map.put("message","保存失败！");
//        }
//        return map;
//    }
//
//    //保存修改后的文章并发布
//    @PostMapping(value = "/edit/{topicId}")
//    public Map<String,String> updateTopic(String context, @PathVariable("topicId")Integer topicId,String priority) {
//            String Title = context.substring(context.indexOf("#"), context.indexOf("\n"));
//            Title = Title.substring(Title.lastIndexOf("#") + 1);
//            Title.trim();
//            Title = Title.replace("\r","");
//            String topicType = context.substring(context.indexOf("星期") + 5, context.indexOf("星期") + 7);
//            String time = context.substring(context.indexOf(")|") + 2, context.indexOf(")|") + 21);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date topicDate = new Date();
//            try {
//                topicDate = sdf.parse(time);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//
//            Topic topic = articleService.getTopicById(topicId);
//            User author = userService.getAdUserById(topic.getAuthor().getId());
//            topic.setId(topic.getId());
//            topic.setAuthor(author);
//            topic.setTopicType(topicType);
//            topic.setTopicDate(topicDate);
//            topic.setContent(context);
//            topic.setEdtext(context);
//            topic.setTitle(Title);
//            topic.setPriority(priority);
//            Integer rows = articleService.editTopic(topic);
//            Map<String,String> map=new HashMap<String,String>();
//            if (rows != 0){
//                map.put("status","1");
//                map.put("message","修改成功！");
//            }else {
//                map.put("status", "0");
//                map.put("message", "修改失败！");
//            }
//            return map;
//    }
//
//    @GetMapping(value = "/{user}/search")
//    public Map<String,String> search(@PathVariable Integer topicId, String keyword) {
//        List<Topic> topicList = articleService.getAllTopic(topicId);
//        Map<String,String> results = new HashMap<String, String>();
//        for (Topic topic:topicList) {
//            int titleIndex =topic.getTitle().indexOf(keyword);
//            int contentIndex =topic.getContent().indexOf(keyword);
//            if((titleIndex!=-1)||(contentIndex!=-1)){
//                results.put("value",topic.getTitle());
//                results.put("id",topic.getId().toString());
//            }
//        }
//        return results;
//    }
//
//    @PostMapping(value = "/delTopic/{topicId}")
//    public Map<String,String> delTopic(@PathVariable("topicId") Integer topicId){
//        articleService.delTopic(topicId);
//        Map<String,String> map=new HashMap<String,String>();
//        BlogMsg blogMsg = blogService.getBlogMsg();
//        blogService.updateEssayNum(blogMsg.getEssayNum()-1);
//        map.put("code","1");
//        return map;
//    }
}
