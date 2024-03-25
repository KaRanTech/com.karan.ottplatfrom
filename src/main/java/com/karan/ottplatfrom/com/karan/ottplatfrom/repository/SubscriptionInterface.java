package com.karan.ottplatfrom.com.karan.ottplatfrom.repository;

import com.karan.ottplatfrom.com.karan.ottplatfrom.model.RegistoreModel.subscription.SubscriptionModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionInterface extends MongoRepository<SubscriptionModel,Long> {

    @Query("{userName : '?0'}")
    List<SubscriptionModel> findByUserName(@Param("userName") String userName);

}
