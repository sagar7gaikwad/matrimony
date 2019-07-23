package com.hcl.matrimonyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimonyapp.service.RegisterServiceImpl;

@RestController
public class RegisterController {

	@Autowired
	private RegisterServiceImpl RegisterServiceImpl;
	
	@RequestMapping("/register")
	public ResponseEntity<Object> registerUser(){
		return null;
	}
}
