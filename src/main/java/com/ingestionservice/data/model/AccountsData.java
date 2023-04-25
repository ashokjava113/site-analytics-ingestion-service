package com.ingestionservice.data.model;


import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@Document(collection = "GainsightPX_Accounts")
public class AccountsData {

    @Id
    private String id;
    private String name;
    private String lastModifiedDate;
    private String createDate;
    private String plan;
    private Long numberOfEmployees;
    private boolean isDeleted;
    private String naicsCode;
    private String trackedSubscriptionId;

}
