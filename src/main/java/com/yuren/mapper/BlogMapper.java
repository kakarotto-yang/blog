package com.yuren.mapper;

import com.yuren.pojo.Blog;

import java.util.List;

public interface BlogMapper {
    Blog getBlogMsg();
    void updateRunningDays(Integer n);
    void updateEssayNum(Integer n);
    void updateviews(Integer n);
    void updateCommentNum(Integer n);
}
