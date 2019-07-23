package com.hcl.matrimonyapp.repository;



import java.util.List;

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

	UserProfile findByUserId(Long loggedUserId);

}
