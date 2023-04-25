package com.ingestionservice.data.functional;

import com.ingestionservice.data.model.AccountCustomEvent;
import org.apache.commons.csv.CSVRecord;

public class AccountCustomEventMapper implements CSVMapper{

    public static final String DATE = "date";
    public static final String ACCOUNT_ID = "accountId";
    public static final String PRODUCT_KEY = "productKey";
    public static final String ENVIRONMENT = "environment";
    public static final String EVENT_NAME = "eventName";
    public static final String COUNT = "count";

    @Override
    public AccountCustomEvent mapRecord(CSVRecord record){
        return new AccountCustomEvent()
                .setDate(record.get(DATE))
                .setAccountId(record.get(ACCOUNT_ID))
                .setProductKey(record.get(PRODUCT_KEY))
                .setEnvironment(record.get(ENVIRONMENT))
                .setEventName(record.get(EVENT_NAME))
                .setCount(record.get(COUNT));
    }

    @Override
    public String[] getHeaders() {
        return new String[]{DATE,ACCOUNT_ID,PRODUCT_KEY,ENVIRONMENT,EVENT_NAME,COUNT};
    }

}
