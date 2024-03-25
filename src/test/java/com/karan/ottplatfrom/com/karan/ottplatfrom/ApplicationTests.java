package com.karan.ottplatfrom.com.karan.ottplatfrom;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karan.ottplatfrom.com.karan.ottplatfrom.model.RegistoreModel.RegistoreModel;
import com.karan.ottplatfrom.com.karan.ottplatfrom.repository.RegisterFormInterface;
import com.karan.ottplatfrom.com.karan.ottplatfrom.service.RegisterFormService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

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
