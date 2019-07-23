package com.hcl.matrimonyapp.repository;



<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 105f51dac27e6e9f064dbfa3af3af04559109e26
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.matrimonyapp.entity.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

<<<<<<< HEAD
	@Query("SELECT  u FROM  UserProfile u INNER JOIN Favourites f ON u.userId = f.likedUserProfile WHERE f.likedUserProfile = :favMeId")
	List<UserProfile> findByFavMeId(@Param(value="favMeId") long fevMeId);
=======
	UserProfile findByUserId(Long loggedUserId);

>>>>>>> 105f51dac27e6e9f064dbfa3af3af04559109e26
}
