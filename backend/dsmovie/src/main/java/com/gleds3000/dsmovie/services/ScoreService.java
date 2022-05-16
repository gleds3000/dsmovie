package com.gleds3000.dsmovie.services;


import com.gleds3000.dsmovie.dto.MovieDTO;
import com.gleds3000.dsmovie.dto.ScoreDTO;
import com.gleds3000.dsmovie.entities.Movie;
import com.gleds3000.dsmovie.entities.Score;
import com.gleds3000.dsmovie.entities.User;
import com.gleds3000.dsmovie.repositories.MovieRepository;
import com.gleds3000.dsmovie.repositories.ScoreRepository;
import com.gleds3000.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);// estudar mais o save and flush
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());
//Save And Flush garante atualizar os dados
        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()) {
            sum += s.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }
}
