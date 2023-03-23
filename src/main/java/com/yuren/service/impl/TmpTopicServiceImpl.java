package com.yuren.service.impl;

import com.yuren.mapper.TmpTopicMapper;
import com.yuren.pojo.TmpTopic;
import com.yuren.service.TmpTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TmpTopicServiceImpl implements TmpTopicService {
    @Autowired
    private TmpTopicMapper tmpTopicMapper;

    public TmpTopic loadTempAddTopic(Integer id) {
        return tmpTopicMapper.loadTempAddTopic(id);
    }

    public Integer createTmpTopic(Integer id) {
        return tmpTopicMapper.createTmpTopic(id);
    }

    public Integer tmpSave(Integer id, String context) {
        return tmpTopicMapper.tmpSave(id,context);
    }

    public void tmpClear(Integer id) {
        tmpTopicMapper.tmpClear(id);
    }
}
