package com.hcl.matrimonyapp.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import com.hcl.matrimonyapp.entity.Favourites;
import com.hcl.matrimonyapp.entity.UserProfile;
import com.hcl.matrimonyapp.repository.FavouritesRepository;
import com.hcl.matrimonyapp.repository.UserProfileRepository;

@Service
public class InterestService {

	@Autowired
	FavouritesRepository favouritesRepository;

	@Autowired
	UserProfileRepository userProfileRepository;

	Favourites favourites;

	public void validateUserIdAndaddLike(Long loggedUserId, Long likedUserId) {

		UserProfile loggedUser = userProfileRepository.findByUserId(loggedUserId);
		UserProfile likedUser = userProfileRepository.findByUserId(likedUserId);
		Long logUserId = loggedUser.getUserId();
		Long likeUserId = likedUser.getUserId();
		List<Favourites> favList = userProfileRepository.findByMyFavList();
		for (Favourites favourites : favList) {
			if((favourites.getMyUserProfile().equals(logUserId)) == favourites.getMyUserProfile().equals(likeUserId)){
				//throw new LikeAleradyPresentException();
				System.out.println("You Already Liked this profile");
			}
			
		}
		
		if ((!ObjectUtils.isEmpty(loggedUser)) && (!ObjectUtils.isEmpty(likedUser))) {

			favourites = new Favourites();
			favourites.setDate(LocalDate.now());
			favourites.setMyUserProfile(loggedUser);
			favourites.setLikedUserProfile(likedUser);
			favouritesRepository.save(favourites);

		}

	}

}
