package com.sotero.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sotero.dsmovie.dto.MovieDTO;
import com.sotero.dsmovie.dto.ScoreDTO;
import com.sotero.dsmovie.entities.Movie;
import com.sotero.dsmovie.entities.Score;
import com.sotero.dsmovie.entities.User;
import com.sotero.dsmovie.repositories.MovieRepository;
import com.sotero.dsmovie.repositories.ScoreRepository;
import com.sotero.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	public UserRepository userRepository;
	@Autowired
	public ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		double sum = 0;
		score = scoreRepository.saveAndFlush(score);
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum/movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
		
	}
	
	
	
}
