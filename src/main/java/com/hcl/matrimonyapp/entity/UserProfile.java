package com.hcl.matrimonyapp.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
public class UserProfile implements Serializable {

	private static final long serialVersionUID = -1309879943918759004L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Long age;

	@Column(name = "occupation")
	private String occupation;

	@Column(name = "gender")
	private String gender;

	@Column(name = "complexion")
	private String complexion;

	@Column(name = "height")
	private Double height;

	@Column(name = "weight")
	private Double weight;

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

	@OneToMany(mappedBy = "myUserProfile", cascade = CascadeType.ALL)
	private List<Favourites> myFavList;

	@OneToMany(mappedBy = "likedUserProfile", cascade = CascadeType.ALL)
	private List<Favourites> favMeList;

	@Column(name = "current_addr")
	private String currentAddr;

	@Column(name = "native_addr")
	private String navtiveAddr;

}
