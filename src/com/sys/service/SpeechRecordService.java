package com.sys.service;

import com.sys.persistence.domain.SpeechRecord;

import java.util.List;

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

    /**
     * Gets speech record by user id and date.
     *
     * @param userId    the user id
     * @param dateBegin the date begin
     * @param dateEnd   the date end
     * @return the speech record by user id and date
     */
    List<SpeechRecord> getSpeechRecordByUserIdAndDate(Integer userId, String dateBegin, String dateEnd);
}
