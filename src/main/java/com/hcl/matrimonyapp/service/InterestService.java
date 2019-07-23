package com.hcl.matrimonyapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.matrimonyapp.dto.UserProfileDTO;
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

	public void validateUserIdAndaddLike(Long loggedUserId, Long likedUserId) {

		UserProfile loggedUser = userProfileRepository.findByUserId(loggedUserId);
		UserProfile likedUser = userProfileRepository.findByUserId(likedUserId);

		if ((!ObjectUtils.isEmpty(loggedUser)) && (!ObjectUtils.isEmpty(likedUser))) {

			favourites = new Favourites();
			favourites.setDate(LocalDate.now());
			favourites.setMyUserProfile(loggedUser);
			favourites.setLikedUserProfile(likedUser);
			favouritesRepository.save(favourites);

		}

	}

	public List<UserProfileDTO> likedMe(@RequestParam("userId") Long userId) {
		
		List<UserProfileDTO> userRespList = new ArrayList<>();
		List<UserProfile> userList = userProfileRepository.getByFavMeId(userId);
		if(userList == null ) {
			return userRespList;
		}
		userList.forEach(u ->{
			UserProfileDTO userDTO = new UserProfileDTO();
			userDTO.setUserId(u.getUserId());
			userDTO.setName(u.getName());
			userDTO.setBloodGrp(u.getBloodGrp());
			userDTO.setCaste(u.getCaste());
			userDTO.setComplexion(u.getComplexion());
			userDTO.setCurrentAddr(u.getCurrentAddr());
			userDTO.setDob(u.getDob());
			userDTO.setEducation(u.getEducation());
			userDTO.setGender(u.getGender());
			userDTO.setHeight(u.getHeight());
			userDTO.setWeight(u.getWeight());
			userDTO.setNavtiveAddr(u.getNavtiveAddr());
			userDTO.setOccupation(u.getOccupation());
			userRespList.add(userDTO);
			
		});
		return userRespList;
	}
	public List<UserProfileDTO>  likedByMe(@RequestParam("userId") Long userId) {
		
		List<UserProfileDTO> userRespList = new ArrayList<>();
		List<UserProfile> userList = userProfileRepository.getByMyFavId(userId);
		if(userList == null ) {
			return userRespList;
		}
		userList.forEach(u ->{
			UserProfileDTO userDTO = new UserProfileDTO();
			userDTO.setUserId(u.getUserId());
			userDTO.setName(u.getName());
			userDTO.setBloodGrp(u.getBloodGrp());
			userDTO.setCaste(u.getCaste());
			userDTO.setComplexion(u.getComplexion());
			userDTO.setCurrentAddr(u.getCurrentAddr());
			userDTO.setDob(u.getDob());
			userDTO.setEducation(u.getEducation());
			userDTO.setGender(u.getGender());
			userDTO.setHeight(u.getHeight());
			userDTO.setWeight(u.getWeight());
			userDTO.setNavtiveAddr(u.getNavtiveAddr());
			userDTO.setOccupation(u.getOccupation());
			userRespList.add(userDTO);
			
		});
		return userRespList;
	}

}
