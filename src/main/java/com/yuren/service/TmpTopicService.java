package com.yuren.service;

import com.yuren.pojo.TmpTopic;

public interface TmpTopicService {
    TmpTopic loadTempAddTopic(Integer id);

    Integer createTmpTopic(Integer id);

    Integer tmpSave(Integer id, String context);

    void tmpClear(Integer id);
}
