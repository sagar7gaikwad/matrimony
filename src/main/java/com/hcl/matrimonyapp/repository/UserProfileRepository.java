package com.hcl.matrimonyapp.repository;



import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.matrimonyapp.entity.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	@Query("SELECT u FROM  UserProfile u INNER JOIN Favourites f ON u.userId = f.myUserProfile WHERE f.likedUserProfile.id = :favMeId")
	List<UserProfile> getByFavMeId(@Param(value="favMeId") long fevMeId);
	
	@Query("SELECT u FROM  UserProfile u INNER JOIN Favourites f ON u.userId = f.likedUserProfile WHERE f.myUserProfile.id = :myFavId")
	List<UserProfile> getByMyFavId(@Param(value="myFavId") long myFavId);
	
	@Query(value = "select * from user_profile where user_id = :userId and password = :password",nativeQuery = true)
	public UserProfile getUserProfile(Long userId, String password);

	public Optional<UserProfile> findByUserId(Long userId);
	
	public List<UserProfile> findByCurrentAddrAndNativeAddrAndEducationAndOccupationAndGender(String currentAddr,String nativeAddr,String education, String occuption, String gender);
	
	@Query(value = "SELECT * FROM user_profile u WHERE u.age >= :fromAge and u.age<= :toAge", nativeQuery = true)
	public List<UserProfile> findAllBetweenAges(@Param("fromAge")Integer fromAge, @Param("toAge")Integer toAge);
	
	@Query(value= "SELECT u FROM user_profile u WHERE u.height >= :fromHeight and u.height <= :toHeight", nativeQuery = true)
	public List<UserProfile> findByHeightRangeBetween(Double fromHeight, Double toHeight);
	
}
