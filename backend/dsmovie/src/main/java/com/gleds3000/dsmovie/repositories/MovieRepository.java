package com.gleds3000.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gleds3000.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
