package com.ingestionservice.data.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ingestionservice.data.functional.AccountCustomEventMapper;
import com.ingestionservice.data.functional.AccountsMapper;
import com.ingestionservice.data.model.AccountsData;
import com.ingestionservice.data.repository.MongoAccountCustomEventRepository;
import com.ingestionservice.data.repository.MongoAccountsRepository;
import com.ingestionservice.util.Mappers;
import com.ingestionservice.util.Streams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    @Value("${aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3Client;

    private final MongoAccountsRepository mongoAccountsRepository;

    private final MongoAccountCustomEventRepository mongoAccountCustomEventRepository;

    private final MongoTemplate mongoTemplate;

    private final ObjectMapper objectMapper;


    @Override
    public boolean checkS3ObjectValidity(String fileName) {
        log.info("inside checkS3ObjectValidity "+fileName);
        return amazonS3Client.doesObjectExist(bucket, fileName);
    }

    @Override
    public void storeAccounts(String fileName) {
        log.debug("Saving records form csv file to mongodb");
        try(final S3Object s3Object = amazonS3Client.getObject(bucket,fileName)){
            CSVParser csvParser = Mappers.streamToList(s3Object.getObjectContent(),new AccountsMapper());
            AccountsMapper accountsMapper = new AccountsMapper();
            Streams.batchStream(csvParser.stream().map(accountsMapper::mapRecord),10000).
                    forEach(recBatch-> mongoAccountsRepository.bulkUpsert(recBatch, AccountsData.class));
            log.debug("finished saving records from csv to mongo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void storeAccountCustomEvent(String fileName) throws IOException {
        try(final  S3Object s3Object = amazonS3Client.getObject(bucket,fileName)){
            CSVParser csvParser = Mappers.streamToList(s3Object.getObjectContent(),new AccountCustomEventMapper());
            AccountCustomEventMapper accountCustomEventMapper = new AccountCustomEventMapper();
            Streams.batchStream(csvParser.stream().map(accountCustomEventMapper::mapRecord),10000)
                    .forEach(mongoAccountCustomEventRepository::insert);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
