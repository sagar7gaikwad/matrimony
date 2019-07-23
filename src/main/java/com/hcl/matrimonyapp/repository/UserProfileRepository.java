package com.hcl.matrimonyapp.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.matrimonyapp.entity.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	@Query(value = "select * from user_profile where user_id = :userId and password = :password",nativeQuery = true)
	public UserProfile getUserProfile(Long userId, String password);

	//UserProfile findByUserId(Long loggedUserId);

    public Optional<UserProfile> findByUserId(Long userId);
	
	public List<UserProfile> findByCurrentAddrAndNativeAddrAndEducationAndOccupationAndGender(String currentAddr,String nativeAddr,String education, String occuption, String gender);
	
	@Query("SELECT u FROM UserProfile u WHERE u.age <= :fromAge and u.age >= :toAge")
	public List<UserProfile> findByAgeRangeBetween(Integer fromAge, Integer toAge);
	
	@Query("SELECT u FROM UserProfile u WHERE u.height <= :fromHeight and u.height >= :toHeight")
	public List<UserProfile> findByHeightRangeBetween(Double fromHeight, Double toHeight);
	
	
}
