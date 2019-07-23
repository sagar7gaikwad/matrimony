package com.hcl.matrimonyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.matrimonyapp.entity.UserProfile;

@Repository
public interface LoginRepository extends JpaRepository<UserProfile, Long> {

}
