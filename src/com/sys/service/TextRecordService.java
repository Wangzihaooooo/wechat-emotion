package com.sys.service;

import com.sys.persistence.domain.TextRecord;

/**
 * description:
 * Created on 2017/9/22 13:01
 **/
public interface TextRecordService {

    int addTextRecord(TextRecord textRecord);

    TextRecord getTextRecordByRecordId(int recordId);
}
