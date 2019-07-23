package com.hcl.matrimonyapp.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchDTO {
	
	private String currentAddr;
	
	private String nativeAddr;
	
	private String education;

	private String occupation;
	
	private String gender;
	
	private Long fromAge;
	
	private Long toAge;
	
	private Double fromHeight;
	
	private Double toHeight;	

}
