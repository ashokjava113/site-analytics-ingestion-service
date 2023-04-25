package com.ingestionservice.data.functional;

import com.ingestionservice.data.model.AccountsData;
import org.apache.commons.csv.CSVRecord;

public class AccountsMapper implements CSVMapper{

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
    public static final String CREATE_DATE = "createDate";
    public static final String PLAN = "plan";
    public static final String NUMBER_OF_EMPLOYEES = "numberOfEmployees";
    public static final String ISDELETED = "isDeleted";
    public static final String NAICS_CODE = "naicsCode";
    public static final String TRACK_SUBSCRIPTION_ID = "trackSubscriptionId";

    public AccountsData mapRecord(CSVRecord csvRecord){
        return new AccountsData()
                .setId(csvRecord.get(ID))
                .setName(csvRecord.get(NAME))
                .setLastModifiedDate(csvRecord.get(LAST_MODIFIED_DATE))
                .setCreateDate(csvRecord.get(CREATE_DATE))
                .setPlan(csvRecord.get(PLAN))
                .setNumberOfEmployees(Long.valueOf(csvRecord.get(NUMBER_OF_EMPLOYEES)))
                .setName(csvRecord.get(ISDELETED))
                .setNaicsCode(csvRecord.get(NAICS_CODE))
                .setTrackedSubscriptionId(csvRecord.get(TRACK_SUBSCRIPTION_ID));
    }

    public String[] getHeaders(){
        return new String[]{ID,NAME,LAST_MODIFIED_DATE,CREATE_DATE,PLAN,NUMBER_OF_EMPLOYEES,ISDELETED,NAICS_CODE,TRACK_SUBSCRIPTION_ID};
    }
}