package com.kakarotto.service;



import com.kakarotto.common.result.Result;
import com.kakarotto.pojo.Article;
import com.kakarotto.query.ArticleQueryVo;

import java.util.List;

public interface ArticleService {

    Article getArticleById(Integer id);

    Result selectArticlePage(int page, int limit, ArticleQueryVo articleQueryVo);

    void deleteArticle(int id);

    void updateArticle(Article article);

    void createArticle(Article article);
}
