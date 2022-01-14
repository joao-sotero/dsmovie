package com.sotero.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sotero.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	

}
