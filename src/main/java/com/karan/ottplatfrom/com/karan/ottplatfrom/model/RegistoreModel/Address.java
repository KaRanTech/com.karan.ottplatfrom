package com.karan.ottplatfrom.com.karan.ottplatfrom.model.RegistoreModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {


    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
