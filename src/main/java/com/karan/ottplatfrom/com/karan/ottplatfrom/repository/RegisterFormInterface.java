package com.karan.ottplatfrom.com.karan.ottplatfrom.repository;

import com.karan.ottplatfrom.com.karan.ottplatfrom.model.RegistoreModel.RegistoreModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RegisterFormInterface extends MongoRepository<RegistoreModel, UUID> {

    boolean existsByUserName(String name);
    Optional<RegistoreModel> findByUserName(String name);


}
