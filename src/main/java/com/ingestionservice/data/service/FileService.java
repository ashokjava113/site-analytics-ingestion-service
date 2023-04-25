package com.ingestionservice.data.service;

import java.io.IOException;

public interface FileService {

    boolean checkS3ObjectValidity(String fileName);
    void storeAccounts(String fileName);

    void storeAccountCustomEvent(String account_custom_event) throws IOException;
}
