package com.kakarotto.service;



import com.kakarotto.pojo.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> getAllTopic(Integer user);
    Topic getTopicById(Integer id);
    List<Topic> getTopicByType(Integer id, String topicType);
    Integer addTopic(Topic topic);
    Integer editTopic(Topic topic);
    List<Topic> getHotEssay(Integer id);
    List<Topic> getLatestEssay(Integer id);
    Integer updataViews(Integer topicId,Integer n);
    Integer updataPraise(Integer topicId,Integer n);
    Integer delTopic(Integer topicId);

    Integer editSave(Topic topic);

}
