package com.hcl.matrimonyapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchDTO {
	
	private Long userId;
	
	private String currentAddr;
	
	private String nativeAddr;
	
	private String education;

	private String occupation;
	
	private String gender;
	
	private Integer fromAge;
	
	private Integer toAge;
	
	private Double fromHeight;
	
	private Double toHeight;	

}
