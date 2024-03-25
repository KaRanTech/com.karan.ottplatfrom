package com.karan.ottplatfrom.com.karan.ottplatfrom.model.RegistoreModel.subscription;

import com.karan.ottplatfrom.com.karan.ottplatfrom.constants.Subscription;
import com.karan.ottplatfrom.com.karan.ottplatfrom.model.RegistoreModel.RegistoreModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.sql.Timestamp;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionModel {
    @Id
    private String subId;
    private String userName;
    private RegistoreModel userDetails;
    private Subscription perk;
    private String subscibeData;
    private String subscriptionEdndata;
    private String price;
    private String status;

}
