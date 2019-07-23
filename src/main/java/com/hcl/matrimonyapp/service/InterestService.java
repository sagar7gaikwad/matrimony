package com.hcl.matrimonyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimonyapp.entity.Favourites;
import com.hcl.matrimonyapp.entity.UserProfile;
import com.hcl.matrimonyapp.repository.FavouritesRepository;

@Service
public class InterestService {

	@Autowired
	FavouritesRepository favouritesRepository;

	public void validateUserIdAndaddLike(Long loggedUserId, Long likedUserId) {
		
	//	List<UserProfile> userList = favouritesRepository.findByMyUserProfile(loggedUserId);
	//	userList.
	//System.out.println(favouritesRepository.findByFavId(loggedUserId));
	//System.out.println(userList);
		
	
	}
	
}
