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
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;

import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.entity.UserProfile;
import com.hcl.matrimonyapp.exception.ApplicationException;
import com.hcl.matrimonyapp.serviceimpl.RegisterServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RegisterControllerTest {

	@InjectMocks
	RegisterController registerController;

	@Mock
	RegisterServiceImpl registerServiceImplMock;

	UserProfileDTO userProfileDTO = new UserProfileDTO();
	UserProfile userProfile = new UserProfile();

	@Before
	public void setup() {
		userProfileDTO = createUserDTO();
		BeanUtils.copyProperties(userProfileDTO, userProfile);
		userProfile.setUserId(1L);
	}

	@Test
	public void testRegisterUser() throws ApplicationException {
		Mockito.when(registerServiceImplMock.registerUser(Mockito.any(UserProfileDTO.class)))
				.thenReturn("Welcome to HCL Matrimony...\nHello " + userProfileDTO.getName()
						+ ", you are succesfully registerd.\nYour login id is : " + userProfile.getUserId());
		ResponseEntity<Object> registerUser = registerController.registerUser(userProfileDTO);
		assertNotNull(registerUser);
		assertEquals(200, registerUser.getStatusCodeValue());

	}

	@Test(expected = ApplicationException.class)
	public void testRegisterUserMandetoryEleMissing() throws ApplicationException {
		userProfileDTO.setCurrentAddr(null);
		validateMandetoryEleMissingResponse(registerController.registerUser(userProfileDTO), "Current Address");

		UserProfileDTO userProfileDTO1 = createUserDTO();
		userProfileDTO1.setDob(null);
		validateMandetoryEleMissingResponse(registerController.registerUser(userProfileDTO1), "Date of Birth");

		UserProfileDTO userProfileDTO2 = createUserDTO();
		userProfileDTO2.setEducation(null);
		validateMandetoryEleMissingResponse(registerController.registerUser(userProfileDTO2), "Education");

		UserProfileDTO userProfileDTO3 = createUserDTO();
		userProfileDTO1.setGender(null);
		validateMandetoryEleMissingResponse(registerController.registerUser(userProfileDTO3), "Gender");

		UserProfileDTO userProfileDTO4 = createUserDTO();
		userProfileDTO1.setHeight(null);
		validateMandetoryEleMissingResponse(registerController.registerUser(userProfileDTO4), "Height");

		UserProfileDTO userProfileDTO5 = createUserDTO();
		userProfileDTO5.setName(null);
		validateMandetoryEleMissingResponse(registerController.registerUser(userProfileDTO5), "Name");

		UserProfileDTO userProfileDTO6 = createUserDTO();
		userProfileDTO6.setOccupation(null);
		validateMandetoryEleMissingResponse(registerController.registerUser(userProfileDTO6), "Occupation");

		UserProfileDTO userProfileDTO7 = createUserDTO();
		userProfileDTO7.setPassword(null);
		validateMandetoryEleMissingResponse(registerController.registerUser(userProfileDTO7), "Password");

		UserProfileDTO userProfileDTO8 = createUserDTO();
		userProfileDTO8.setUsername(null);
		validateMandetoryEleMissingResponse(registerController.registerUser(userProfileDTO8), "Username");

		UserProfileDTO userProfileDTO9 = createUserDTO();
		userProfileDTO9.setNativeAddr(null);
		validateMandetoryEleMissingResponse(registerController.registerUser(userProfileDTO9), "Navtive Address");

	}

	private void validateMandetoryEleMissingResponse(ResponseEntity<Object> calculateMortgage, String elementName) {
		assertNotNull(calculateMortgage);
		assertEquals(400, calculateMortgage.getStatusCodeValue());
		System.out.println(calculateMortgage.getBody());
		assertEquals("Mandetory Element missing : " + elementName, calculateMortgage.getBody());
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
		userProfileDTO.setNativeAddr("Pune");
		userProfileDTO.setOccupation("Engineer");
		userProfileDTO.setPassword("shiv");
		userProfileDTO.setUsername("shiv");
		userProfileDTO.setWeight(57.0);

		return userProfileDTO;
	}

}
