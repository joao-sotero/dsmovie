package com.sotero.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sotero.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
