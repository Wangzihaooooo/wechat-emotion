package com.sys.service;

import com.sys.persistence.domain.SpeechRecord;

/**
 * description:
 * Created on 2017/9/22 12:57
 */
public interface SpeechRecordService {

    /**
     * Add speech record int.
     *
     * @param speechRecord the speech record
     * @return the int
     */
    int addSpeechRecord(SpeechRecord speechRecord);

    /**
     * Gets speech record by record id.
     *
     * @param recordId the record id
     * @return the speech record by record id
     */
    SpeechRecord getSpeechRecordByRecordId(int recordId);
}
