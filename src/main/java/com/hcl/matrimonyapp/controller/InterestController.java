package com.hcl.matrimonyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimonyapp.service.InterestService;

@RestController
public class InterestController {

	@Autowired
	InterestService interestService;
	public ResponseEntity<Object> like(@RequestParam Integer loggedUserId, @RequestParam Integer likedUserId){
		return new ResponseEntity<>("You Showed intrest in "+"!!!",HttpStatus.OK);
	}
	
}
