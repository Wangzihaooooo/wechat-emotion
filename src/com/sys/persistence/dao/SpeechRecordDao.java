package com.sys.persistence.dao;

import com.sys.persistence.domain.SpeechRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpeechRecordDao {
    int deleteByPrimaryKey(Integer recordId);

    int insert(SpeechRecord record);

    int insertSelective(SpeechRecord record);

    SpeechRecord selectByPrimaryKey(Integer recordId);

    List<SpeechRecord> selectByUserIdAndDate(@Param("userId") Integer userId,
                                             @Param("dateBegin") String dateBegin,
                                             @Param("dateEnd") String dateEnd);

    int updateByPrimaryKeySelective(SpeechRecord record);

    int updateByPrimaryKey(SpeechRecord record);
}