package com.yuren.mapper;

import com.yuren.pojo.TmpTopic;

public interface TmpTopicMapper {
    TmpTopic loadTempAddTopic(Integer id);

    Integer createTmpTopic(Integer id);

    Integer tmpSave(Integer id, String context);

    void tmpClear(Integer id);
}
