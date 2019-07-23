package com.hcl.matrimonyapp.dto;

import java.time.LocalDate;
import java.util.List;

import com.hcl.matrimonyapp.entity.Favourites;

import lombok.Data;

@Data
public class UserProfileDTO {

	// private long userId;

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

	private String currentAddr;

	private String navtiveAddr;

	@Override
	public String toString() {
		return "UserProfileDTO [name=" + name + ", age=" + age + ", occupation=" + occupation + ", gender=" + gender
				+ ", complexion=" + complexion + ", height=" + height + ", weight=" + weight + ", horoscopeDetails="
				+ horoscopeDetails + ", dob=" + dob + ", caste=" + caste + ", education=" + education + ", bloodGrp="
				+ bloodGrp + ", username=" + username + ", currentAddr=" + currentAddr + ", navtiveAddr=" + navtiveAddr
				+ "]";
	}

}
