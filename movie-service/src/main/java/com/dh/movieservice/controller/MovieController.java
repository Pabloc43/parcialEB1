package com.dh.movieservice.controller;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.service.MovieService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RefreshScope
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final MovieService movieService;

    private static java.util.logging.Logger log = Logger.getLogger(MovieController.class.getName());

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> findAll(@RequestParam(defaultValue = "false") Boolean throwError) {
        return movieService.findAll(throwError);
    }

    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(movieService.findByGenre(genre));
    }

    @PostMapping("/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        log.info("Saving movie");
        return ResponseEntity.ok().body(movieService.save(movie));
    }
}
