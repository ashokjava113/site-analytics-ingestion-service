package com.ingestionservice.data.functional;

import org.apache.commons.csv.CSVRecord;

public interface CSVMapper {
    Object mapRecord(CSVRecord csvRecord);
    String[] getHeaders();
}