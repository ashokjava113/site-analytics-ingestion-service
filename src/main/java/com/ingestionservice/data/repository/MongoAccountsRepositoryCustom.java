package com.ingestionservice.data.repository;

import com.ingestionservice.data.model.AccountsData;

import java.util.List;

public interface MongoAccountsRepositoryCustom {
    Integer bulkUpsert(List<AccountsData> collection, Class<AccountsData> accountsDataClass);
}
