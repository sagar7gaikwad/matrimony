package com.hcl.matrimonyapp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.entity.UserProfile;
import com.hcl.matrimonyapp.repository.UserProfileRepository;

/**
 * @author Administrator
 *
 */
@Service
public class LoginService {

	@Autowired
	UserProfileRepository userProfileRepository;
	
	/**
	 * @param userId
	 * @param password
	 * @return object UserProfileDTO
	 */
	public UserProfileDTO getUserProfile(Long userId, String password) {
		UserProfile userProfile = userProfileRepository.getUserProfile(userId, password);
		UserProfileDTO userProfileDTO = null;
		if (null != userProfile) {
			userProfileDTO = new UserProfileDTO();
			BeanUtils.copyProperties(userProfile, userProfileDTO);
		}
		return userProfileDTO;
	}
}
