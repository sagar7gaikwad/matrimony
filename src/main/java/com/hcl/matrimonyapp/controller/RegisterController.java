package com.hcl.matrimonyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.exception.ApplicationException;
import com.hcl.matrimonyapp.serviceImpl.RegisterServiceImpl;

@RestController
public class RegisterController {

	@Autowired
	private RegisterServiceImpl registerServiceImpl;

	/*
	 * This method is used to register user to matrimony site
	 * @param UserProfileDTO User Profile DTO
	 * @throws ApplicationException
	 */
	@PostMapping("/register")
	public ResponseEntity<Object> registerUser(@RequestBody UserProfileDTO userProfileDTO) throws ApplicationException {
		validateUser(userProfileDTO);
		return new ResponseEntity<>(registerServiceImpl.registerUser(userProfileDTO), HttpStatus.OK);
	}

	/*
	 * This method is used to validate incoming registration request
	 * @param UserProfileDTO User Profile DTO
	 * @throws ApplicationException
	 */
	private void validateUser(UserProfileDTO userProfileDTO) throws ApplicationException {
		System.out.println("===inside validateuser");
		if (StringUtils.isEmpty(userProfileDTO.getCurrentAddr())) {
			throw new ApplicationException("Mandetory Element missing : " + "CurrentAddr");
		}
		if (StringUtils.isEmpty(userProfileDTO.getDob())) {
			throw new ApplicationException("Mandetory Element missing : " + "Date of Birth");
		}
		if (StringUtils.isEmpty(userProfileDTO.getEducation())) {
			throw new ApplicationException("Mandetory Element missing : " + "Education");
		}
		if (StringUtils.isEmpty(userProfileDTO.getGender())) {
			throw new ApplicationException("Mandetory Element missing : " + "Gender");
		}
		if (StringUtils.isEmpty(userProfileDTO.getHeight())) {
			throw new ApplicationException("Mandetory Element missing : " + "Height");
		}
		if (StringUtils.isEmpty(userProfileDTO.getName())) {
			throw new ApplicationException("Mandetory Element missing : " + "Name");
		}
		if (StringUtils.isEmpty(userProfileDTO.getOccupation())) {
			throw new ApplicationException("Mandetory Element missing : " + "Occupation");
		}
		if (StringUtils.isEmpty(userProfileDTO.getPassword())) {
			throw new ApplicationException("Mandetory Element missing : " + "Password");
		}
		if (StringUtils.isEmpty(userProfileDTO.getUsername())) {
			throw new ApplicationException("Mandetory Element missing : " + "Username");
		}

	}
}
