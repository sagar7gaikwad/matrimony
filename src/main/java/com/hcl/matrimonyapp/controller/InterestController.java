package com.hcl.matrimonyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.matrimonyapp.exception.ApplicationException;

import com.hcl.matrimonyapp.entity.UserProfile;

import com.hcl.matrimonyapp.service.InterestService;

@RestController
@RequestMapping("/users")
public class InterestController {

	@Autowired
	InterestService interestService;
	
	@PostMapping(value = "/like")
	public ResponseEntity<Object> like(@RequestParam("myUserProfile") Long loggedUserId, 
			@RequestParam("likedUserProfile") Long likedUserId) throws ApplicationException{
		if(!loggedUserId .equals(likedUserId)) {
			interestService.validateUserIdAndaddLike(loggedUserId,likedUserId);
		}
		else
			throw new ApplicationException("You Cannot like your own profile");
		return new ResponseEntity<>("You Showed intrest in "+likedUserId+"!!!",HttpStatus.OK);
	}
	
	
	@GetMapping(value="/likedme")
	public ResponseEntity<List<UserProfile>> likedMe(@RequestParam("userId") Long userId){
		List<UserProfile> userList = interestService.likedMe(userId);
		return new ResponseEntity<>(userList,HttpStatus.OK) ;
	}
	@GetMapping(value="/like")
	public ResponseEntity<List<UserProfile>> likedByMe(@RequestParam("userId") Long userId){
		List<UserProfile> userList = interestService.likedByMe(userId);
		return new ResponseEntity<>(userList,HttpStatus.OK) ;
	}
	
}
