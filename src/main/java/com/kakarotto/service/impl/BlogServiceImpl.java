package com.kakarotto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kakarotto.mapper.BlogMapper;
import com.kakarotto.pojo.BlogMsg;
import com.kakarotto.service.BlogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BlogServiceImpl extends ServiceImpl<BlogMapper, BlogMsg> implements BlogService {

    public BlogMsg getBlogMsg() {
        return baseMapper.selectOne(null);
    }
    public void updateRunningDays(Integer n) {
        BlogMsg blogMsg = baseMapper.selectOne(null);
        blogMsg.setRunningDays(n);
        baseMapper.updateById(blogMsg);
    }

    public void updateCommentNum(Integer n) {
        BlogMsg blogMsg = baseMapper.selectOne(null);
        blogMsg.setCommentNum(n);
        baseMapper.updateById(blogMsg);
    }

    public void updateEssayNum(Integer n) {
        BlogMsg blogMsg = baseMapper.selectOne(null);
        blogMsg.setEssayNum(n);
        baseMapper.updateById(blogMsg);
    }

    public void updateviews(Integer n) {
        BlogMsg blogMsg = baseMapper.selectOne(null);
        blogMsg.setViews(n);
        baseMapper.updateById(blogMsg);
    }
}
