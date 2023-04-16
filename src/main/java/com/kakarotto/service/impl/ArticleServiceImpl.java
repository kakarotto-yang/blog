package com.kakarotto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kakarotto.common.exception.CFException;
import com.kakarotto.common.result.Result;
import com.kakarotto.common.result.ResultCodeEnum;
import com.kakarotto.mapper.ArticleMapper;
import com.kakarotto.pojo.Article;
import com.kakarotto.pojo.Article;
import com.kakarotto.pojo.Comment;
import com.kakarotto.pojo.LoginUser;
import com.kakarotto.query.ArticleQueryVo;
import com.kakarotto.service.ArticleService;
import com.kakarotto.service.CategoryService;
import com.kakarotto.service.CommentService;
import com.mysql.cj.xdevapi.DatabaseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

@Service
@Transactional
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private CategoryService categoryService;

    @Resource
    private CommentService commentService;

    @Autowired
    private CacheManager cacheManager;

    public Article getArticleById(Integer id) {
        return articleMapper.getArticleById(id);
    }

    /*
    * 根据条件分页查询文章
    * */
    @Override
    public Result selectArticlePage(int page, int limit, ArticleQueryVo articleQueryVo) {
        Page<Article> page1 = new Page<>(page,limit);
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        //如果查询条件非空
        if (articleQueryVo != null){
            String title = articleQueryVo.getTitle();
            int category = articleQueryVo.getCategory();
            String beforeCreateTime = articleQueryVo.getBeforeCreateTime();
            String afterCreateTime = articleQueryVo.getAfterCreateTime();
            String beforeUpdateTime = articleQueryVo.getBeforeUpdateTime();
            String afterUpdateTime = articleQueryVo.getAfterUpdateTime();
            if(!StringUtils.isEmpty(title)){
                queryWrapper.like("title",title);
            }
            if(!StringUtils.isEmpty(category)){
                List<Integer> categorys = categoryService.getCategoryChild(category);
                categorys.add(category);
                queryWrapper.in("category",categorys);
            }
            if(!StringUtils.isEmpty(beforeCreateTime)){
                queryWrapper.le("create_time",beforeCreateTime);
            }
            if(!StringUtils.isEmpty(afterCreateTime)){
                queryWrapper.ge("create_time",afterCreateTime);
            }
            if(!StringUtils.isEmpty(beforeUpdateTime)){
                queryWrapper.le("update_time",beforeUpdateTime);
            }
            if(!StringUtils.isEmpty(afterUpdateTime)){
                queryWrapper.ge("update_time",afterUpdateTime);
            }
        }
        //发布的文章才能查询
        queryWrapper.eq("status",1);
        baseMapper.selectPage(page1,queryWrapper);
        Map<String, Object> map = new HashMap<>();
        map.put("article",page1.getRecords());

        return Result.ok(map);
    }

    private boolean isArticleBelongTo(int id){
        Article article = getArticleById(id);
        LoginUser user = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // 检查该文章是否属于当前操作用户
        if (user.getUser().getId().equals(article.getAuthor())) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void deleteArticle(int id) {
        if (!isArticleBelongTo(id)){
            // 没有权限
            throw new CFException(ResultCodeEnum.PERMISSION);
        }
        // 维护该文章的评论等信息，需要一并删除
        // 根据文章id查找评论
        // 批量删除
        List<Comment> commentList = commentService.getCommentByArticleId(id);
        commentService.batchDeleteComment(commentList);
        //TODO 还有其他与文章相关的没删除，但是还没想到
        //删除文章
        baseMapper.deleteById(id);
        cacheManager.getCache("indexPage").clear();
    }

    @Override
    public void updateArticle(Article article) {
        // 判断是否有id属性，可能前端会忘记传
        if (StringUtils.isEmpty(article.getId())){
            throw new CFException(ResultCodeEnum.DATA_ERROR);
        }
        if (!isArticleBelongTo(article.getId())){
            // 没有权限
            throw new CFException(ResultCodeEnum.PERMISSION);
        }
        baseMapper.updateById(article);
        cacheManager.getCache("indexPage").clear();
    }

    @Override
    public void createArticle(Article article) {
        //先获取作者
        LoginUser user = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //设置文章作者
        article.setAuthor(user.getUser().getId());
        baseMapper.insert(article);
        cacheManager.getCache("indexPage").clear();
    }


}
