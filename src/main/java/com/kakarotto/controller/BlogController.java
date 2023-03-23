package com.kakarotto.controller;

import com.kakarotto.pojo.BlogMsg;
import com.kakarotto.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlogController {
    /**
     * 每天执行一次，每天晚上12点
     */
    @Autowired
    BlogService blogService;

    @GetMapping(value = "/getBlogMsg")
    @ResponseBody
    public BlogMsg getBlogMsg(){
        BlogMsg blogMsg = blogService.getBlogMsg();
        return blogMsg;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduledTask(){
        BlogMsg blogMsg = blogService.getBlogMsg();
        blogService.updateRunningDays(blogMsg.getRunningDays()+1);
    }
}
