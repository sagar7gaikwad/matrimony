package com.hcl.matrimonyapp.service;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.matrimonyapp.entity.UserProfile;
import com.hcl.matrimonyapp.repository.UserProfileRepository;
import com.hcl.matrimonyapp.serviceimpl.LoginServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {

	@InjectMocks
	LoginServiceImpl loginServiceImpl;

	@Mock
	UserProfileRepository userProfileRepository;

	@Before
	public void setUp() {

	}

	@Test
	public void testGetUserProfileIfCredentialsAreCorrect() {
		UserProfile userProfile = new UserProfile();
		when(userProfileRepository.getUserProfile(1L, "Jatin")).thenReturn(userProfile);
		Assert.assertNotNull(loginServiceImpl.getUserProfile(1L, "Jatin"));
	}

	@Test
	public void testGetUserProfileIfUserIdIsNull() {
		Assert.assertNull(loginServiceImpl.getUserProfile(null, "Jatin"));
	}
}
