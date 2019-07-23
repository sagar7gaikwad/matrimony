package com.hcl.matrimonyapp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.entity.UserProfile;
import com.hcl.matrimonyapp.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	public UserProfileDTO getUserProfile(Long userId, String password) {
		UserProfile userProfile = loginRepository.getUserProfile(userId, password);
		UserProfileDTO userProfileDTO = new UserProfileDTO();
		BeanUtils.copyProperties(userProfile, userProfileDTO);
		
		return userProfileDTO;
	}
}
