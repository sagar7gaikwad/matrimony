package com.hcl.matrimonyapp.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.entity.UserProfile;
import com.hcl.matrimonyapp.repository.UserProfileRepository;
import com.hcl.matrimonyapp.service.LoginService;

/**
 * @author Administrator
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	UserProfileRepository userProfileRepository;

	/**
	 * @param userId
	 * @param password
	 * @return object of UserProfileDTO
	 */
	public UserProfileDTO getUserProfile(Long userId, String password) {
		logger.debug("Inside getUserProfile method of Login serviceImpl.......");
		UserProfile userProfile = userProfileRepository.getUserProfile(userId, password);
		UserProfileDTO userProfileDTO = null;
		if (null != userProfile) {
			userProfileDTO = new UserProfileDTO();
			BeanUtils.copyProperties(userProfile, userProfileDTO);
		}
		logger.debug("exiting from getUserProfile method of Login serviceImpl.......");
		return userProfileDTO;
	}
}
