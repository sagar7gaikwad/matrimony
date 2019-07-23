package com.hcl.matrimonyapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestParam;

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

	Favourites favouritess;

	public void validateUserIdAndaddLike(Long loggedUserId, Long likedUserId) throws ApplicationException {

		Optional<UserProfile> loggedUserOp = userProfileRepository.findById(loggedUserId);

		Optional<UserProfile> likedUserOp = userProfileRepository.findById(likedUserId);
		UserProfile loggedUser = null;
		UserProfile likedUser = null;

		if (loggedUserOp.isPresent()) {
			loggedUser = loggedUserOp.get();
		}
		if (likedUserOp.isPresent()) {
			likedUser = likedUserOp.get();
		}

		List<Favourites> fev = loggedUser.getMyFavList();
		for (Favourites favourites : fev) {
			if (favourites.getLikedUserProfile().getUserId().equals(likedUser.getUserId())) {
				throw new ApplicationException("you Already Liked this Profile");
			}

		}
		if ((!ObjectUtils.isEmpty(loggedUser)) && (!ObjectUtils.isEmpty(likedUser))) {
			favouritess = new Favourites();
			favouritess.setDate(LocalDate.now());
			favouritess.setMyUserProfile(loggedUser);
			favouritess.setLikedUserProfile(likedUser);
			favouritesRepository.save(favouritess);

		}

	}

	public List<UserProfile> likedMe(@RequestParam("userId") Long userId) {
		return userProfileRepository.getByFavMeId(userId);
	}

	public List<UserProfile> likedByMe(@RequestParam("userId") Long userId) {
		return userProfileRepository.getByMyFavId(userId);
	}

}
