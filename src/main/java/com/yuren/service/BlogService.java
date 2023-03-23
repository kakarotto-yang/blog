package com.yuren.service;

import com.yuren.pojo.Blog;

import java.util.List;

public interface BlogService {
    Blog getBlogMsg();
    void updateRunningDays(Integer n);
    void updateCommentNum(Integer n);
    void updateEssayNum(Integer n);
    void updateviews(Integer n);
}
