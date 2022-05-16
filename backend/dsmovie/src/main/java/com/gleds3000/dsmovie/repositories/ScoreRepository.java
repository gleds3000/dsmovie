package com.gleds3000.dsmovie.repositories;

import com.gleds3000.dsmovie.entities.Score;
import com.gleds3000.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
