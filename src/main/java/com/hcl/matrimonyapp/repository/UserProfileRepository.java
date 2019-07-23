package com.hcl.matrimonyapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.matrimonyapp.entity.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	@Query(value = "select * from user_profile where user_id = :userId and password = :password",nativeQuery = true)
	public UserProfile getUserProfile(Long userId, String password);

	UserProfile findByUserId(Long loggedUserId);

}
