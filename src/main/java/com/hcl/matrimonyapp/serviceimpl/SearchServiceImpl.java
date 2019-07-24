package com.hcl.matrimonyapp.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimonyapp.entity.UserProfile;
import com.hcl.matrimonyapp.exception.ApplicationException;
import com.hcl.matrimonyapp.model.UserSearchDTO;
import com.hcl.matrimonyapp.repository.UserProfileRepository;
import com.hcl.matrimonyapp.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public List<UserProfile> searchProfiles( UserSearchDTO userRequest) throws ApplicationException{
		List<UserProfile> userList = new ArrayList();

		if (userRequest.getUserId()!= null && userRequest.getUserId() !=0) {
			Optional<UserProfile> profile = userProfileRepository.findByUserId(userRequest.getUserId());
			if (profile.isPresent())
				userList.add(profile.get());
			
		}else if (userRequest.getFromAge() != null && userRequest.getToAge() != null) {
			userList =  userProfileRepository.findAllBetweenAges(userRequest.getFromAge(), userRequest.getToAge());
			
		} else if (userRequest.getFromHeight() != null && userRequest.getToHeight() != null) {
			userList =  userProfileRepository.findByHeightRangeBetween(userRequest.getFromHeight(), userRequest.getToHeight());
			
		}else if (userRequest.getCurrentAddr() != null && userRequest.getNativeAddr() != null
				&& userRequest.getEducation() != null && userRequest.getOccupation() != null
				&& userRequest.getGender() != null) {
			userList =  userProfileRepository.findByCurrentAddrAndNativeAddrAndEducationAndOccupationAndGender(
					userRequest.getCurrentAddr(), userRequest.getNativeAddr(), userRequest.getEducation(),
					userRequest.getOccupation(), userRequest.getGender());
		}else {
			throw new ApplicationException("Invalid Input");
		}

		return userList;
	}
}