package com.hcl.matrimonyapp.service;

import org.springframework.stereotype.Service;

import com.hcl.matrimonyapp.dto.UserProfileDTO;

/**
 * @author Administrator
 *
 */
@Service
public interface LoginService {

	public UserProfileDTO getUserProfile(Long userId, String password);
}
