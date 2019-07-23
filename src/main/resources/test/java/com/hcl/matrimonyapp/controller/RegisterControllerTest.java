package com.hcl.matrimonyapp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.exception.ApplicationException;
import com.hcl.matrimonyapp.serviceimpl.RegisterServiceImpl;


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
	public void testRegisterUser() throws ApplicationException {
		Mockito.when(registerServiceImplMock.registerUser(Mockito.any(UserProfileDTO.class))).thenReturn("");
		ResponseEntity<Object> registerUser = registerController.registerUser(userProfileDTO);
		assertNotNull(registerUser);
		assertEquals(200, registerUser.getStatusCodeValue());
		
	}
	
	private UserProfileDTO createUserDTO() {
		UserProfileDTO userProfileDTO = new UserProfileDTO();
		userProfileDTO.setBloodGrp("A+");
		userProfileDTO.setCaste("Maratha");
		userProfileDTO.setComplexion("Fair");
		userProfileDTO.setCurrentAddr("Pune");
		userProfileDTO.setDob(LocalDate.of(1992, 05, 22));
		userProfileDTO.setEducation("MTech");
		userProfileDTO.setGender("Female");
		userProfileDTO.setHeight(5.4);
		userProfileDTO.setHoroscopeDetails("capricorn");
		userProfileDTO.setName("Shivanjali");
		userProfileDTO.setNavtiveAddr("Pune");
		userProfileDTO.setOccupation("Engineer");
		userProfileDTO.setPassword("shiv");
		userProfileDTO.setUsername("shiv");
		userProfileDTO.setWeight(57.0);
		
		return userProfileDTO;
	}
	
}
