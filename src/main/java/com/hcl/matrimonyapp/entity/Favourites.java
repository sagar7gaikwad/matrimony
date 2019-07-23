package com.hcl.matrimonyapp.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "favId")
public class Favourites {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fav_Id")
	private Long favId;
	
	@ManyToOne
	@JoinColumn(name = "my_fav_id")
	private UserProfile  myUserProfile;
	
	@ManyToOne
	@JoinColumn(name = "fav_me_id")
	private UserProfile likedUserProfile;
	
	@Column(name="date")
	private LocalDate date;
	

}
