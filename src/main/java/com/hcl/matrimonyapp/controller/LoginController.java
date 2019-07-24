package com.hcl.matrimonyapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimonyapp.dto.LoginDTO;
import com.hcl.matrimonyapp.dto.UserProfileDTO;
import com.hcl.matrimonyapp.exception.ApplicationException;
import com.hcl.matrimonyapp.service.LoginService;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginService loginService;

	/**
	 * @param loginDTO
	 * @return object of ResponseEntity
	 * @throws ApplicationException
	 */
	@PostMapping("")
	public ResponseEntity<Object> login(@RequestBody LoginDTO loginDTO) throws ApplicationException {

		logger.debug("Inside login method of Login controller.......");
		UserProfileDTO userProfileDTO = null;
		validate(loginDTO);
		userProfileDTO = loginService.getUserProfile(loginDTO.getUserId(), loginDTO.getPassword());
		if (null == userProfileDTO) {
			logger.error("Invalid credentials are inserted........");
			throw new ApplicationException("Please enter valid credentials.");
		}
		logger.debug("exiting from login method of Login controller.......");
		return new ResponseEntity<>(userProfileDTO, HttpStatus.OK);

	}

	private void validate(LoginDTO loginDTO) throws ApplicationException {
		if (null == loginDTO || null == loginDTO.getUserId() || StringUtils.isEmpty(loginDTO.getUserId())
				|| null == loginDTO.getPassword() || StringUtils.isEmpty(loginDTO.getPassword()))
			throw new ApplicationException("Please enter valid credentials.");
	}
}
