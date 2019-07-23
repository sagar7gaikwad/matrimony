package com.hcl.matrimonyapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.matrimonyapp.entity.UserProfile;

@Repository
public interface SearchRepository extends JpaRepository<UserProfile,Integer> {
	
	public UserProfile findByUserId(Long userId);
	
	public List<UserProfile> findByCurrentAddrAndNativeAddrAndEducationAndOccupationAndGender();
	
	@Query("SELECT u FROM UserProfile u WHERE u.age <= :fromAge and u.age >= :toAge")
	public List<UserProfile> findByAgeRangeBetween(Long fromAge, Long toAge);
	
	@Query("SELECT u FROM UserProfile u WHERE u.height <= :fromHeight and u.height >= :toHeight")
	public List<UserProfile> findByHeightRangeBetween(Double fromHeight, Double toHeight);
	
	

}
