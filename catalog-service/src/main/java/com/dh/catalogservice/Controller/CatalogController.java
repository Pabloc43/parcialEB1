package com.dh.catalogservice.Controller;

import com.dh.catalogservice.feign.IMovie;
import com.dh.catalogservice.Model.DTO.Movie;
import com.dh.catalogservice.Model.DTO.Serie;

import com.dh.catalogservice.feign.ISerie;
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
public class CatalogController {

    @Autowired
    private IMovie movieClient;
    @Autowired
    private ISerie serieClient;

    private static final Logger logger = LoggerFactory.getLogger(CatalogController.class);

    @GetMapping("/movie/{genre}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre) {
        return movieClient.getMovieByGenre(genre);
    }

    @PostMapping("/movie/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        return movieClient.saveMovie(movie);
    }

    @GetMapping("/movie")
    public List<Movie> getAllMovies(@RequestParam(defaultValue = "false") Boolean throwError) {
        return movieClient.findAll(throwError);
    }

    @GetMapping("/serie")
    public List<Serie> getAllSeries() {
        return serieClient.getAll();
    }

    @GetMapping("/serie/{genre}")
    public List<Serie> getSeriesByGenre(@PathVariable String genre) {
        return serieClient.getSerieByGenre(genre);
    }

    @PostMapping("/serie/save")
    public String create(@RequestBody Serie serie){
        logger.info("Creating serie");
        return serieClient.create(serie);
    }
}
