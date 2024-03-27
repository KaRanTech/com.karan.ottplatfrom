package com.karan.ottplatfrom.com.karan.ottplatfrom.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karan.ottplatfrom.com.karan.ottplatfrom.model.RegistoreModel.RegistoreModel;
import com.karan.ottplatfrom.com.karan.ottplatfrom.model.RegistoreModel.subscription.SubscriptionModel;
import com.karan.ottplatfrom.com.karan.ottplatfrom.repository.RegisterFormInterface;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class RegisterServiceTest {

    @InjectMocks
    private RegisterFormService registerFormService;

    @Mock
    private RegisterFormInterface registerFormInterface;

    @Mock
    private ObjectMapper mapper;

    @Test
    void userNameValidationTest(){
        RegistoreModel model = new RegistoreModel();
        model.setUserName("karan123");
        Assertions.assertEquals(registerFormService.userNameValidation(model),true);
        model.setUserName("kara");
        Assertions.assertEquals(registerFormService.userNameValidation(model),false);
    }
}
