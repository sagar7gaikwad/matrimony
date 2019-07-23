package com.hcl.matrimonyapp.service;

import java.util.List;

import com.hcl.matrimonyapp.entity.UserProfile;
import com.hcl.matrimonyapp.exception.ApplicationException;
import com.hcl.matrimonyapp.model.UserSearchDTO;

public interface SearchService {
	
	public List<UserProfile> searchProfiles(UserSearchDTO userRequest) throws ApplicationException;

}
