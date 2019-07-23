package com.hcl.matrimonyapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.matrimonyapp.entity.Favourites;
import com.hcl.matrimonyapp.entity.UserProfile;

@Repository
public interface FavouritesRepository extends JpaRepository<Favourites, Long> {

	List<UserProfile> findByMyUserProfile(Long loggedUserId);

	@Query(value = "select * from favourites where favId =?1" , nativeQuery = true)
	Favourites findByFavId(Long loggedUserId);


	
}
