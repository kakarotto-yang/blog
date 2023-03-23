package com.yuren.controller;

import com.yuren.pojo.Blog;
import com.yuren.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BlogController {
    /**
     * 每天执行一次，每天晚上12点
     */
    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/getBlogMsg")
    @ResponseBody
    public Blog getBlogMsg(){
        Blog blog = blogService.getBlogMsg();
        return blog;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduledTask(){
        Blog blog = blogService.getBlogMsg();
        blogService.updateRunningDays(blog.getRunningDays()+1);
    }
}
