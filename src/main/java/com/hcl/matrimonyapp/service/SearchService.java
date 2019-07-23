package com.hcl.matrimonyapp.service;

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
public class SearchService {

	@Autowired
	SearchRepository searchRepository;
	
	public List<UserProfile> searchProfiles(Long userId, UserProfileDTO userProfileDTO){
		if (null != userId) {
			Optional<UserProfile> profile= searchRepository.findByUserId(userId);
			if (profile.isPresent()) {
				return profile.get();
			}
			
		}
		else 
		{
			
			return searchRepository.findByCurrentAddrAndNativeAddrAndEducationAndOccupationAndGender();
        }
         
		throw new ApplicationException("Invalid input entered");
	}
	
}
