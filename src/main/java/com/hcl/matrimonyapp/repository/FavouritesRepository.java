package com.hcl.matrimonyapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hcl.matrimonyapp.entity.Favourites;


@Repository
public interface FavouritesRepository extends JpaRepository<Favourites, Long> {

	

	
}
