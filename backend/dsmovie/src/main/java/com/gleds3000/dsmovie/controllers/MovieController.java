package com.gleds3000.dsmovie.controllers;

import com.gleds3000.dsmovie.dto.MovieDTO;
import com.gleds3000.dsmovie.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private MovieService service;

    @GetMapping
    public Page<MovieDTO> findAll(Pageable pageable){

        return service.findAll(pageable);
    }

    @GetMapping(value = "/{id}" )
    public MovieDTO findById(@PathVariable Long id){

        LOGGER.info("Detalhes do filme por Id {}", id);


        return service.findById(id);
    }
}
