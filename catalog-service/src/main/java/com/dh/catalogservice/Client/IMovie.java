package com.dh.catalogservice.Client;


import com.dh.catalogservice.Model.DTO.Movie;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("movie-service")
@LoadBalancerClient(name = "movie-service")
public interface IMovie {
        @GetMapping("/api/v1/movies/{genre}")
        ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre);

        @PostMapping("/api/v1/movies/save")
        ResponseEntity<Movie> saveMovie(@RequestBody Movie movie);
}
