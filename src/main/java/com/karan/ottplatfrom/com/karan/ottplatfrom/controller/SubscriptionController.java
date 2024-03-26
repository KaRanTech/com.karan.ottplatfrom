package com.karan.ottplatfrom.com.karan.ottplatfrom.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.karan.ottplatfrom.com.karan.ottplatfrom.model.RegistoreModel.subscription.SubscriptionModel;
import com.karan.ottplatfrom.com.karan.ottplatfrom.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @PostMapping("/subscribe")
    public ResponseEntity
    subscribe(@RequestBody SubscriptionModel model) throws JsonProcessingException {
        return service.subscribe(model);
    }

    @PatchMapping("/updateSubscribe")
    public  ResponseEntity update(@RequestBody SubscriptionModel model){
        return service.updateSub(model);

    }
}
