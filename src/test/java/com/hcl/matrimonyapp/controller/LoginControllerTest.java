package com.hcl.matrimonyapp.controller;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.matrimonyapp.dto.LoginDTO;
import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.service.LoginService;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	@InjectMocks
	LoginController loginController;
	
	@Mock
	LoginService loginService;
	
	LoginDTO loginDTO;
	
	@Before
	public void setUp() {
		loginDTO = new LoginDTO();
	}
	
	@Test
	public void loginIfCredentialDetailsAreCorrect() {
		loginDTO.setPassword("Jatin@123");
		loginDTO.setUserId(1L);
		UserProfileDTO userProfileDTO = new UserProfileDTO();
		when(loginService.getUserProfile(loginDTO.getUserId(), loginDTO.getPassword())).thenReturn(userProfileDTO);
		Assert.assertNotNull(loginController.login(loginDTO));
	}
	
	@Test
	public void loginIfPasswordIsNull() {
		loginDTO.setPassword(null);
		loginDTO.setUserId(1L);
		Assert.assertNotNull(loginController.login(loginDTO));
	}
	
	@Test
	public void loginIfUserIdIsNull() {
		loginDTO.setPassword("Jatin@123");
		loginDTO.setUserId(null);
		Assert.assertNotNull(loginController.login(loginDTO));
	}
}
