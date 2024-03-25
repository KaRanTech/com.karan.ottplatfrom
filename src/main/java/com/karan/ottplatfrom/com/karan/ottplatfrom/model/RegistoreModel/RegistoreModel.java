package com.karan.ottplatfrom.com.karan.ottplatfrom.model.RegistoreModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistoreModel implements Serializable {

    @Id
    private UUID id;
    @Indexed(unique = true)
    private String userName;
    private String password;
    private String gender;
    private Address address;

}
