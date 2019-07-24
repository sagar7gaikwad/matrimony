package com.hcl.matrimonyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.dto.UserSearchDTO;
import com.hcl.matrimonyapp.exception.ApplicationException;
import com.hcl.matrimonyapp.serviceimpl.SearchServiceImpl;

@Controller
public class SearchController {

	@Autowired
	SearchServiceImpl searchServiceImpl;

	@PostMapping("/profiles")
    public ResponseEntity<List<UserProfileDTO>> searchProfile( @RequestBody UserSearchDTO userRequest ) throws ApplicationException {
		
		return new ResponseEntity<>(searchServiceImpl.searchProfiles(userRequest),HttpStatus.OK);
	}
}
