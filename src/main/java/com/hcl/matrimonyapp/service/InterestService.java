package com.hcl.matrimonyapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.hcl.matrimonyapp.entity.Favourites;
import com.hcl.matrimonyapp.entity.UserProfile;
import com.hcl.matrimonyapp.exception.ApplicationException;
import com.hcl.matrimonyapp.repository.FavouritesRepository;
import com.hcl.matrimonyapp.repository.UserProfileRepository;

@Service
public class InterestService {

	@Autowired
	FavouritesRepository favouritesRepository;

	@Autowired
	UserProfileRepository userProfileRepository;

	Favourites favourites;

	public void validateUserIdAndaddLike(Long loggedUserId, Long likedUserId) throws ApplicationException {

		UserProfile loggedUser = userProfileRepository.findByUserId(loggedUserId);
		//System.out.println(loggedUser);
		UserProfile likedUser = userProfileRepository.findByUserId(likedUserId);
		//System.out.println(likedUser);
		List<Favourites> fev = loggedUser.getMyFavList();
			for (Favourites favourites : fev) {
				if (favourites.getMyUserProfile().equals(loggedUser.getUserId()) == favourites.getLikedUserProfile()
						.equals(likedUser.getUserId())) {
					throw new ApplicationException("you Already Liked this Profile");
				}

				else if ((!ObjectUtils.isEmpty(loggedUser)) && (!ObjectUtils.isEmpty(likedUser))) {
					favourites = new Favourites();
					favourites.setDate(LocalDate.now());
					favourites.setMyUserProfile(loggedUser);
					favourites.setLikedUserProfile(likedUser);
					favouritesRepository.save(favourites);

				}

			}

		}


}
