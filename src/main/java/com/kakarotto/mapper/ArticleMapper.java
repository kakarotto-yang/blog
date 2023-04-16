package com.kakarotto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kakarotto.pojo.Article;
import com.kakarotto.pojo.Article;

import java.util.Date;
import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {


    Article getArticleById(Integer id);
    List<Article> getArticleByType(Integer id, String topicType);
    Integer addArticle(Integer id, String topicType, Date topicDate, String title, String content, String priority);
    //编辑更新
    Integer editArticle(Integer id, String topicType, Date topicDate, String title, String content, Integer id1, String priority);
    //删除帖子
    Integer delArticle(Integer topic);
    List<Article> getHotEssay(Integer id);
    List<Article> getLatestEssay(Integer id);
    Integer updataViews(Integer topicId, Integer n);
    Integer updataPraise(Integer topicId, Integer n);

    Integer editSave(Integer id, String edtext);

}
