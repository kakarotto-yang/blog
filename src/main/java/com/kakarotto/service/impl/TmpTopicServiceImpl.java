package com.kakarotto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kakarotto.mapper.TmpTopicMapper;
import com.kakarotto.pojo.TmpTopic;
import com.kakarotto.service.TmpTopicService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class TmpTopicServiceImpl extends ServiceImpl<TmpTopicMapper,TmpTopic> implements TmpTopicService {

    public TmpTopic loadTempAddTopic(Integer id) {
        QueryWrapper<TmpTopic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("author",id);
        return baseMapper.selectOne(queryWrapper);
    }

    public Integer createTmpTopic(Integer id) {
        TmpTopic tmpTopic = new TmpTopic();
        tmpTopic.setAuthor(id);
        return baseMapper.insert(tmpTopic);
    }

    public Integer tmpSave(Integer id, String context) {
        TmpTopic tmpTopic = new TmpTopic();
        tmpTopic.setAuthor(id);
        tmpTopic.setContent(context);
        return baseMapper.updateById(tmpTopic);
    }

    public void tmpClear(Integer id) {
        QueryWrapper<TmpTopic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("author",id);
        baseMapper.delete(queryWrapper);
    }
}
