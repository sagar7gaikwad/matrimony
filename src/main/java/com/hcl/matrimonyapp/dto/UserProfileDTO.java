package com.hcl.matrimonyapp.dto;

import java.time.LocalDate;
import java.util.List;

import com.hcl.matrimonyapp.entity.Favourites;

import lombok.Data;

@Data
public class UserProfileDTO {

	//private long userId;

	private String name;

	private long age;

	private String occupation;

	private String gender;

	private String complexion;

	private double height;

	private double weight;

	private String horoscopeDetails;

	private LocalDate dob;

	private String caste;

	private String education;

	private String bloodGrp;

	private String password;

	private String username;

	private List<Favourites> myFavList;

	private List<Favourites> favMeList;

	private String currentAddr;

	private String navtiveAddr;

	@Override
	public String toString() {
		final int maxLen = 10;
		return "UserProfileDTO [name=" + name + ", age=" + age + ", occupation=" + occupation + ", gender=" + gender
				+ ", complexion=" + complexion + ", height=" + height + ", weight=" + weight + ", horoscopeDetails="
				+ horoscopeDetails + ", dob=" + dob + ", caste=" + caste + ", education=" + education + ", bloodGrp="
				+ bloodGrp + ", username=" + username + ", myFavList="
				+ (myFavList != null ? myFavList.subList(0, Math.min(myFavList.size(), maxLen)) : null) + ", favMeList="
				+ (favMeList != null ? favMeList.subList(0, Math.min(favMeList.size(), maxLen)) : null)
				+ ", currentAddr=" + currentAddr + ", navtiveAddr=" + navtiveAddr + "]";
	}
	
	

}
