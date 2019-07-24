package com.hcl.matrimonyapp.util;

import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.entity.UserProfile;

public class UserProfileMapper {
	
	public static UserProfileDTO mapUserProfileDTOToResponseList(UserProfile u) {
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
		userDTO.setNativeAddr(u.getNativeAddr());
		userDTO.setOccupation(u.getOccupation());
		return userDTO;
		
	}

}
