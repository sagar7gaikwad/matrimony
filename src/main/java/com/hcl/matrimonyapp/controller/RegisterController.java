package com.hcl.matrimonyapp.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.exception.ApplicationException;
import com.hcl.matrimonyapp.serviceimpl.RegisterServiceImpl;

@RestController
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class); 
	
	@Autowired
	private RegisterServiceImpl registerServiceImpl;
	
	private static final String ERROR_MSG = "Mandetory Element missing : ";

	/*
	 * This method is used to register user to matrimony site
	 * @param UserProfileDTO User Profile DTO
	 * @throws ApplicationException
	 */
	@PostMapping("/register")
	public ResponseEntity<Object> registerUser(@RequestBody UserProfileDTO userProfileDTO) throws ApplicationException {
		logger.info("Received register user request.");
		validateUser(userProfileDTO);
		logger.info("Register user request validated sucessfully.");
		String registerUserStatus = registerServiceImpl.registerUser(userProfileDTO);
		logger.info("Returning sucessful register user response.");
		return new ResponseEntity<>(registerUserStatus, HttpStatus.OK);
	}

	/*
	 * This method is used to validate incoming registration request
	 * @param UserProfileDTO User Profile DTO
	 * @throws ApplicationException
	 */
	private void validateUser(UserProfileDTO userProfileDTO) throws ApplicationException {
		if (StringUtils.isEmpty(userProfileDTO.getCurrentAddr())) {
			throw new ApplicationException(ERROR_MSG + "Current Address");
		}
		if (StringUtils.isEmpty(userProfileDTO.getNativeAddr())) {
			throw new ApplicationException(ERROR_MSG + "Navtive Address");
		}
		if (StringUtils.isEmpty(userProfileDTO.getDob())) {
			throw new ApplicationException(ERROR_MSG + "Date of Birth");
		}
		if (StringUtils.isEmpty(userProfileDTO.getEducation())) {
			throw new ApplicationException(ERROR_MSG + "Education");
		}
		if (StringUtils.isEmpty(userProfileDTO.getGender())) {
			throw new ApplicationException(ERROR_MSG + "Gender");
		}
		if (StringUtils.isEmpty(userProfileDTO.getHeight())) {
			throw new ApplicationException(ERROR_MSG + "Height");
		}
		if (StringUtils.isEmpty(userProfileDTO.getName())) {
			throw new ApplicationException(ERROR_MSG + "Name");
		}
		if (StringUtils.isEmpty(userProfileDTO.getOccupation())) {
			throw new ApplicationException(ERROR_MSG + "Occupation");
		}
		if (StringUtils.isEmpty(userProfileDTO.getPassword())) {
			throw new ApplicationException(ERROR_MSG + "Password");
		}
		if (StringUtils.isEmpty(userProfileDTO.getUsername())) {
			throw new ApplicationException(ERROR_MSG + "Username");
		}

	}
}
