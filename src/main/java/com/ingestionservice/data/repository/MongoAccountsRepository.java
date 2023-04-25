package com.ingestionservice.data.repository;

import com.ingestionservice.data.model.AccountsData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MongoAccountsRepository extends MongoRepository<AccountsData, UUID>,MongoAccountsRepositoryCustom, PagingAndSortingRepository<AccountsData,UUID> {
}
