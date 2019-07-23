package com.hcl.matrimonyapp.serviceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.entity.UserProfile;
import com.hcl.matrimonyapp.exception.ApplicationException;
import com.hcl.matrimonyapp.model.UserSearchDTO;
import com.hcl.matrimonyapp.repository.SearchRepository;

@Service
public class SearchServiceImpl {

	@Autowired
	SearchRepository searchRepository;
	
	List<UserProfile> users=new ArrayList();
	
	public List<UserProfile> searchProfiles(Long userId, UserProfileDTO userRequest){
		if (null != userId) {
			Optional<UserProfile> profile= searchRepository.findByUserId(userId);
			if (profile.isPresent()) 
				users.add(profile);
				return users;
			}
		else 
		{
			Period diff = Period.between(userRequest.getDob(), LocalDate.now());
			return searchRepository.findByCurrentAddrAndNativeAddrAndEducationAndOccupationAndGender();
        }
         
		throw new ApplicationException("Invalid input entered");
	}
	
}
