package com.yuren.service.impl;

import com.yuren.mapper.BlogMapper;
import com.yuren.pojo.Blog;
import com.yuren.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    public Blog getBlogMsg() {
        return blogMapper.getBlogMsg();
    }
    public void updateRunningDays(Integer n) {
        blogMapper.updateRunningDays(n);
    }

    public void updateCommentNum(Integer n) {
        blogMapper.updateCommentNum(n);
    }

    public void updateEssayNum(Integer n) {
        blogMapper.updateEssayNum(n);
    }

    public void updateviews(Integer n) {
        blogMapper.updateviews(n);
    }
}
