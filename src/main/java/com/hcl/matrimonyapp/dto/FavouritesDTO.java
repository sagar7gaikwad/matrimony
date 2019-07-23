package com.hcl.matrimonyapp.dto;

import java.time.LocalDate;



import com.hcl.matrimonyapp.entity.UserProfile;

import lombok.Data;

@Data
public class FavouritesDTO {

private Long favId;
	
	
	private UserProfile  myUserProfile;
	
	private UserProfile likedUserProfile;
	
	private LocalDate date;
	

}
