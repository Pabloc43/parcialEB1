package com.dh.catalogservice.Controller;

import com.dh.catalogservice.Client.IMovie;
import com.dh.catalogservice.Model.DTO.Movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieController {

    @Autowired
    private IMovie movieClient;

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);


    @GetMapping("/prueba")
    public String prueba(){
        return "prueba";
    }
    @GetMapping("/{genre}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre) {
        return movieClient.getMovieByGenre(genre);

    }

    @PostMapping("/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        return movieClient.saveMovie(movie);
    }



}
