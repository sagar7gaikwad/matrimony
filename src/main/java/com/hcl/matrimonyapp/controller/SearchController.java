package com.hcl.matrimonyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.matrimonyapp.entity.UserProfile;
import com.hcl.matrimonyapp.exception.ApplicationException;
import com.hcl.matrimonyapp.model.UserSearchDTO;
import com.hcl.matrimonyapp.serviceimpl.SearchServiceImpl;

@Controller
public class SearchController {
	
	@Autowired
	SearchServiceImpl  searchService;
	
	@PostMapping("/profiles")
	public ResponseEntity<List<UserProfile>> searchProfile( @RequestBody UserSearchDTO userRequest ) throws ApplicationException {
		return new ResponseEntity<>(searchService.searchProfiles(userRequest),HttpStatus.OK);
	}
}
	
