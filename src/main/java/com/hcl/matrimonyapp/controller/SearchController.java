package com.hcl.matrimonyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.matrimonyapp.entity.UserProfile;
import com.hcl.matrimonyapp.exception.ApplicationException;
import com.hcl.matrimonyapp.model.UserSearchDTO;
import com.hcl.matrimonyapp.service.SearchService;

@Controller
public class SearchController {
	
	@Autowired
	SearchService  searchService;
	
	@GetMapping("/profiles")
	public ResponseEntity<List<UserProfile>> searchProfile(@RequestParam Long userId, @RequestParam UserSearchDTO userSearchDTO ) throws ApplicationException {
		return new ResponseEntity<>(searchService.searchProfiles(userId, userSearchDTO),
				HttpStatus.OK);
	}
}
	
