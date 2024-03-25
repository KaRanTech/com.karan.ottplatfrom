package com.karan.ottplatfrom.com.karan.ottplatfrom.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karan.ottplatfrom.com.karan.ottplatfrom.model.RegistoreModel.RegistoreModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.karan.ottplatfrom.com.karan.ottplatfrom.repository.RegisterFormInterface;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class RegisterFormService {
    Logger logeer = LoggerFactory.getLogger(RegisterFormService.class);

    @Autowired
    private  RegisterFormInterface registoryInterface;

    @Autowired
    private ObjectMapper mapper;

    public String newRegisterForm(RegistoreModel model) throws JsonProcessingException {
        logeer.info("RegistoreForm Details Saved Before...."+mapper.writeValueAsString(model.toString()));
        if(userNameValidation(model)) {
            if(!userExits(model.getUserName())) {
                model.setId(UUID.randomUUID());
                registoryInterface.save(model);
                logeer.info("RegistoreForm Details Saved into...." + mapper.writeValueAsString(model.toString()));
                return "New Register Form Saved....!";
            }else{
                return "User already exists.....!!";
            }

        }else {
            return "User Name not in correct format....!";
        }
    }

    public boolean userNameValidation(RegistoreModel model){
        String regex = "^[A-Za-z]\\w{5,29}$";
        boolean userNameValid = false;
        if(!model.getUserName().isEmpty()){
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(model.getUserName());
            if(m.matches()) {
                return userNameValid = true;
            }
        }
        return userNameValid;
    }

    public boolean userExits(String userName){
        Optional<RegistoreModel> model = registoryInterface.findByUserName(userName);
        if(model.isPresent()){
            return true;
        }else{
            return false;
        }
    }

    public ResponseEntity<RegistoreModel> getUserInfo(String userName){
       RegistoreModel model = new RegistoreModel();
        Optional<RegistoreModel> user = registoryInterface.findByUserName(userName);

        if(user.isPresent()){
            model = user.get();
            return ResponseEntity.status(HttpStatus.OK).body(model);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);
        }
    }
}
