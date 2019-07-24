package com.hcl.matrimonyapp.service;

import java.util.List;

import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.dto.UserSearchDTO;
import com.hcl.matrimonyapp.exception.ApplicationException;

public interface SearchService {
	
	public List<UserProfileDTO> searchProfiles(UserSearchDTO userRequest) throws ApplicationException;

}
