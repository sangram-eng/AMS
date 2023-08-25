package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ams.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
 

}
