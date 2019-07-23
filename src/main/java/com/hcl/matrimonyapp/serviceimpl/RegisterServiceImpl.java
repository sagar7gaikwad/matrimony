package com.hcl.matrimonyapp.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.entity.UserProfile;
import com.hcl.matrimonyapp.repository.UserProfileRepository;
import com.hcl.matrimonyapp.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

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
//		 String userName = userProfileRepository.save(userProfile).getName();
	//	 return "Welcome to HCL Matrimony...\n Hello " +userName+ ", you are succesfully registerd to HCL Matrimony.";
		UserProfile savedUser = userProfileRepository.save(userProfile);
		return "Welcome to HCL Matrimony...\nHello " + savedUser.getName()
				+ ", you are succesfully registerd.\nYour login id is : " + savedUser.getUserId();
	}
	
	

}