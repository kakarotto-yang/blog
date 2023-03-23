package com.yuren.service.impl;

import com.yuren.mapper.TopicMapper;
import com.yuren.pojo.Topic;
import com.yuren.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicMapper topicMapper;

    public List<Topic> getAllTopic(Integer topicId) {
        return topicMapper.getAllTopic(topicId);
    }

    public Topic getTopicById(Integer id) {
        return topicMapper.getTopicById(id);
    }

    public List<Topic> getTopicByType(Integer id, String topicType) {
        return topicMapper.getTopicByType(id,topicType);
    }

    public Integer addTopic(Topic topic) {
        return topicMapper.addTopic(topic.getAuthor().getId(),topic.getTopicType(),topic.getTopicDate(),topic.getTitle(),topic.getContent(),topic.getPriority());
    }


    public Integer editTopic(Topic topic) {
        return topicMapper.editTopic(topic.getAuthor().getId(),topic.getTopicType(),topic.getTopicDate(),topic.getTitle(),topic.getContent(),topic.getId(),topic.getPriority());
    }

    public List<Topic> getHotEssay(Integer id) {
        return topicMapper.getHotEssay(id);
    }

    public List<Topic> getLatestEssay(Integer id) {
        return topicMapper.getLatestEssay(id);
    }

    public Integer updataViews(Integer topicId,Integer n) {
        return topicMapper.updataViews(topicId,n);
    }

    public Integer updataPraise(Integer topicId,Integer n) {
        return topicMapper.updataPraise(topicId,n);
    }

    public Integer delTopic(Integer topicId) {
        return topicMapper.delTopic(topicId);
    }

    public Integer editSave(Topic topic) {
        return topicMapper.editSave(topic.getId(),topic.getEdtext());
    }


}
