package com.kakarotto.service;

import com.kakarotto.pojo.BlogMsg;

public interface BlogService {
    BlogMsg getBlogMsg();
    void updateRunningDays(Integer n);
    void updateCommentNum(Integer n);
    void updateEssayNum(Integer n);
    void updateviews(Integer n);
}
