package com.karan.ottplatfrom.com.karan.ottplatfrom.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karan.ottplatfrom.com.karan.ottplatfrom.constants.Subscription;
import com.karan.ottplatfrom.com.karan.ottplatfrom.model.RegistoreModel.RegistoreModel;
import com.karan.ottplatfrom.com.karan.ottplatfrom.model.RegistoreModel.subscription.SubscriptionModel;
import com.karan.ottplatfrom.com.karan.ottplatfrom.repository.RegisterFormInterface;
import com.karan.ottplatfrom.com.karan.ottplatfrom.repository.SubscriptionInterface;
import org.springdoc.api.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionInterface subscriptionInterface;

    @Autowired
    private RegisterFormInterface registerFormInterface;

    public ResponseEntity subscribe(SubscriptionModel model) throws JsonProcessingException {
       //if(perkValidation(model.getPerk())) {
        RegistoreModel regModel = new RegistoreModel();
        Optional<RegistoreModel> registoreModel = registerFormInterface.findByUserName(model.getUserName());
        if(registoreModel.isPresent()){
            regModel = registoreModel.get();
            model.setUserDetails(regModel);
        }
        List<String> statusCode = Arrays.asList("ACTIVE","INACTIVE", "RENEWAL", "");
            List<SubscriptionModel> subS = subscriptionInterface.findByUserName(model.getUserName());
            System.out.println("User Details:"+new ObjectMapper().writeValueAsString(subS.toString()));
           if(!subS.isEmpty()) {
               for (SubscriptionModel subscription : subS) {
                   if (statusCode.contains(subscription.getStatus()) && !model.getPerk().getName().equalsIgnoreCase(subscription.getPerk().getName())) {
                       model.setSubId(UUID.randomUUID().toString());
                       model.getUserDetails().setId(UUID.randomUUID());
                       subscriptionInterface.save(model);
                       return ResponseEntity.status(HttpStatus.OK).body(model);
                   } else {
                       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("That Perk already Subscribed.....!");
                   }
               }
           }
           else if(statusCode.contains(model.getStatus())){
               model.setSubId(UUID.randomUUID().toString());
               model.getUserDetails().setId(UUID.randomUUID());
               subscriptionInterface.save(model);
               return ResponseEntity.status(HttpStatus.OK).body(model);
           }
        //}
        ErrorMessage errorMessage = new ErrorMessage("In valid Perk");
     return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Perk Validation is Fails...!");
    }

    private boolean perkValidation(Subscription perk){
        List<Subscription> list = new ArrayList<Subscription>(EnumSet.allOf(Subscription.class));
        if(list.contains(perk.getName())){
        return  true;
        }
        return false;
    }
}