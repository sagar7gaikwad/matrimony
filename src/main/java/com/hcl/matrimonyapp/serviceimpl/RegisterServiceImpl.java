package com.hcl.matrimonyapp.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimonyapp.controller.RegisterController;
import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.entity.UserProfile;
import com.hcl.matrimonyapp.repository.UserProfileRepository;
import com.hcl.matrimonyapp.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class); 
	
	@Autowired
	private UserProfileRepository userProfileRepository;

	/*
	 * This method is used to register user to matrimony site
	 * @param UserProfileDTO User Profile DTO
	 */
	@Override
	public String registerUser(UserProfileDTO userProfileDTO) {
		UserProfile userProfile = new UserProfile();
		BeanUtils.copyProperties(userProfileDTO, userProfile);
		UserProfile savedUser = userProfileRepository.save(userProfile);
		logger.info("User data saved sucssesfully.");
		logger.debug("Registered User data :" + savedUser );
		return "Welcome to HCL Matrimony...\nHello " + savedUser.getName()
				+ ", you are succesfully registerd.\nYour login id is : " + savedUser.getUserId();
	}
	
	

}
