package com.sys.service.Impl;

import com.sys.persistence.dao.TextRecordDao;
import com.sys.persistence.domain.TextRecord;
import com.sys.service.TextRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description:
 * Created on 2017/9/22 13:02
 **/
@Service
public class TextRecordServiceImpl implements TextRecordService {
    @Resource
    private TextRecordDao textRecordDao;
    @Override
    public int addTextRecord(TextRecord textRecord) {
        return textRecordDao.insertSelective(textRecord);
    }

    @Override
    public TextRecord getTextRecordByRecordId(int recordId) {
        return textRecordDao.selectByPrimaryKey(recordId);
    }
}
