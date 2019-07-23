package com.hcl.matrimonyapp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.matrimonyapp.entity.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	@Query("SELECT  u FROM  UserProfile u INNER JOIN Favourites f ON u.userId = f.likedUserProfile WHERE f.likedUserProfile = :favMeId")
	List<UserProfile> findByFavMeId(@Param(value="favMeId") long fevMeId);
}
