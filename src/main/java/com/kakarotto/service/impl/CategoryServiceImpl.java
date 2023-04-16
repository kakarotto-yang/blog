package com.kakarotto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kakarotto.mapper.CategoryMapper;
import com.kakarotto.pojo.Category;
import com.kakarotto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Integer> getCategoryChild(int parents) {
        List<Integer> childList = new ArrayList<>();
        getCategoryChild(childList,parents);
        return childList;
    }

    private void getCategoryChild(List<Integer> childs, int parent) {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<Category>()
                .eq(Category::getParentId, parent)  // 查询 parents_id 等于 parents 的用户
                .select(Category::getId);  // 查询 id 字段
        List<Category> temp = categoryMapper.selectList(wrapper);
        for (Category category : temp) {
            int child = category.getId();
            childs.add(child);
            getCategoryChild(childs,child);
        }
    }
}
