package com.hcl.matrimonyapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.serviceImpl.RegisterServiceImpl;

@RestController
public class RegisterController {

	@Autowired
	private RegisterServiceImpl RegisterServiceImpl;
	
	@RequestMapping("/register")
	public ResponseEntity<Object> registerUser(@Valid @RequestBody UserProfileDTO userProfileDTO){
		RegisterServiceImpl.registerUser(userProfileDTO);
		return new ResponseEntity<>(RegisterServiceImpl.registerUser(userProfileDTO), HttpStatus.OK);
	}
}
