package com.ingestionservice.data.repository;

import com.ingestionservice.data.model.AccountCustomEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoAccountCustomEventRepository extends MongoRepository<AccountCustomEvent,String> {
}
