package com.hcl.matrimonyapp.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.serviceImpl.RegisterServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RegisterControllerTest {

	@InjectMocks
	RegisterController registerController;
	
	@Mock
	RegisterServiceImpl registerServiceImplMock;
	
	UserProfileDTO userProfileDTO = new UserProfileDTO();
	
	@Before
	public void setup() {
		userProfileDTO = createUserDTO();
	}
	
	@Test
	public void testRegisterUser() {
		//Mockito.when(mortgageServiceMock.getOffers(userRequest)).thenReturn(offerList);
		//ResponseEntity<?> calculateMortgage = mortgageController.calculateMortgage(userRequest);
		Mockito.when(registerServiceImplMock.registerUser(Mockito.any(UserProfileDTO.class))).thenReturn("Welcome to HCL Matrimony...\nHello " + savedUser.getName()
				+ ", you are succesfully registerd.\nYour login id is : " + savedUser.getUserId());
		
	}
	
	private UserProfileDTO createUserDTO() {
		
	}
	
}
