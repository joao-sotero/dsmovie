package com.sotero.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sotero.dsmovie.entities.Score;
import com.sotero.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
	
	

}
