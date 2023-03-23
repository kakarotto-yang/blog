package com.kakarotto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kakarotto.pojo.Topic;

import java.util.Date;
import java.util.List;

public interface TopicMapper extends BaseMapper<Topic> {


    Topic getTopicById(Integer id);
    List<Topic> getTopicByType(Integer id, String topicType);
    Integer addTopic(Integer id, String topicType, Date topicDate, String title, String content, String priority);
    //编辑更新
    Integer editTopic(Integer id, String topicType, Date topicDate, String title, String content, Integer id1, String priority);
    //删除帖子
    Integer delTopic(Integer topic);
    List<Topic> getHotEssay(Integer id);
    List<Topic> getLatestEssay(Integer id);
    Integer updataViews(Integer topicId, Integer n);
    Integer updataPraise(Integer topicId, Integer n);

    Integer editSave(Integer id, String edtext);

}
