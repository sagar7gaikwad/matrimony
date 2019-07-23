package com.hcl.matrimonyapp.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserProfileDTO {

	private String name;

	private String occupation;

	private String gender;

	private String complexion;

	private Double height;

	private Double weight;

	private String horoscopeDetails;

	private LocalDate dob;

	private String caste;

	private String education;

	private String bloodGrp;

	@JsonIgnore
	private String password;

	private String username;

	private String currentAddr;

	private String navtiveAddr;

	@Override
	public String toString() {
		return "UserProfileDTO [name=" + name + ", occupation=" + occupation + ", gender=" + gender
				+ ", complexion=" + complexion + ", height=" + height + ", weight=" + weight + ", horoscopeDetails="
				+ horoscopeDetails + ", dob=" + dob + ", caste=" + caste + ", education=" + education + ", bloodGrp="
				+ bloodGrp + ", username=" + username + ", currentAddr=" + currentAddr + ", navtiveAddr=" + navtiveAddr
				+ "]";
	}

}
