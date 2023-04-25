package com.ingestionservice.util;

import com.ingestionservice.data.functional.CSVMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

@Slf4j
public class Mappers {

    public static Double asDouble(String csvRecordValue) {
        try {
            return csvRecordValue == null ? null : Double.parseDouble(csvRecordValue);
        }catch(NumberFormatException e){
            log.error("Error Parsing '{}'",csvRecordValue);
            throw e;
        }
    }

    public static Short asShort(String csvRecordValue) {
        try {
            return csvRecordValue == null ? null : Short.parseShort(csvRecordValue);
        }catch(NumberFormatException e){
            log.error("Error Parsing '{}'",csvRecordValue);
            throw e;
        }
    }

    @SneakyThrows
    public static CSVParser streamToList(InputStream is, CSVMapper mapper) {
        Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
        //RFC4180 Format, with headers
        CSVFormat format = CSVFormat.Builder.create()
                .setDelimiter(',')
                .setQuote('"')
                .setRecordSeparator("\r\n")
                .setIgnoreEmptyLines(false)
                .setHeader(mapper.getHeaders())
                .setSkipHeaderRecord(true)
                .setNullString("")
                .build();
        return format.parse(reader);
    }

}
