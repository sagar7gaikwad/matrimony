package com.hcl.matrimonyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimonyapp.dto.LoginDTO;
import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("")
	public ResponseEntity<Object> login(@RequestBody LoginDTO loginDTO) {

		UserProfileDTO userProfileDTO = null;
		if (!isNullOrEmpty(loginDTO) && !isNullOrEmpty(loginDTO.getUserId())
				&& !isNullOrEmpty(loginDTO.getPassword())) {
			userProfileDTO = loginService.getUserProfile(loginDTO.getUserId(), loginDTO.getPassword());
			if (!isNullOrEmpty(userProfileDTO))
				return new ResponseEntity<>(userProfileDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>("Please enter valid credentials.", HttpStatus.BAD_REQUEST);
	}

	private boolean isNullOrEmpty(Object object) {
		return (null == object || " ".equals(object));
	}
}
