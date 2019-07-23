package com.hcl.matrimonyapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.hcl.matrimonyapp.entity.Favourites;

import lombok.Data;

@Data
public class UserProfileDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long userId;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private long age;

	@Column(name = "occupation")
	private String occupation;

	@Column(name = "gender")
	private String gender;

	@Column(name = "complexion")
	private String complexion;

	@Column(name = "height")
	private double height;

	@Column(name = "weight")
	private double weight;

	@Column(name = "horoscopeDetails")
	private String horoscopeDetails;

	@Column(name = "dob")
	private LocalDate dob;

	@Column(name = "caste")
	private String caste;

	@Column(name = "education")
	private String education;

	@Column(name = "blood_grp")
	private String bloodGrp;

	@Column(name = "password")
	private String password;

	@Column(name = "username")
	private String username;

	// @Column(name = "my_fav_list")
	@OneToMany(mappedBy = "myUserProfile", cascade = CascadeType.ALL)
	private List<Favourites> myFavList;

	// @Column(name = "fav_me_list")
	@OneToMany(mappedBy = "likedUserProfile", cascade = CascadeType.ALL)
	private List<Favourites> favMeList;

	@Column(name = "current_addr")
	private String currentAddr;

	@Column(name = "native_addr")
	private String navtiveAddr;

}
