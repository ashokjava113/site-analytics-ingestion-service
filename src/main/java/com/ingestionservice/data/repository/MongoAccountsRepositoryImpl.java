package com.ingestionservice.data.repository;

import com.ingestionservice.data.model.AccountsData;
import com.mongodb.MongoCommandException;
import com.mongodb.bulk.BulkWriteResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.mongodb.UncategorizedMongoDbException;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class MongoAccountsRepositoryImpl implements MongoAccountsRepositoryCustom{

    private final MongoTemplate mongoTemplate;
    @Override
    @Retryable(value = {UncategorizedMongoDbException.class, MongoCommandException.class},
            maxAttempts = 3, backoff = @Backoff(delay = 250))
    @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "mongoTransactionManager")
    public Integer bulkUpsert(List<AccountsData> collection, Class<AccountsData> accountsDataClass) {
        BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED,accountsDataClass);
        collection.forEach(document -> {
            Document doc = new Document();
            mongoTemplate.getConverter().write(document,doc);
            Query query = new Query(Criteria.where("_id").is(doc.get("_id")));
            Document updateDoc = new Document();
            updateDoc.append("$set",doc);
            Update update = Update.fromDocument(updateDoc,"_id");
            bulkOperations.upsert(query,update);
        });
        BulkWriteResult result = bulkOperations.execute();
        return result.getMatchedCount() + result.getUpserts().size();
    }
}
