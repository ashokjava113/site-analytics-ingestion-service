package com.ingestionservice.data.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "GainsightPX_Account_Custom_Event")
public class AccountCustomEvent {

    private String date;
    private String accountId;
    private String productKey;
    private String environment;
    private String eventName;
    private String count;
}
