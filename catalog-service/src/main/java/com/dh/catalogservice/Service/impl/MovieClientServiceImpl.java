package com.dh.catalogservice.Service.impl;

import com.dh.catalogservice.Model.DTO.Movie;
import com.dh.catalogservice.Service.MovieService;
import com.dh.catalogservice.feign.IMovie;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MovieClientServiceImpl implements MovieService {
    private IMovie movieRepository;

    @Autowired
    public MovieClientServiceImpl(IMovie movieRepository) {
        this.movieRepository = movieRepository;
    }

    @CircuitBreaker(name = "movie-service", fallbackMethod = "fallback")
    @Override
    public List<Movie> findAll(Boolean throwError) {
        return movieRepository.findAll(throwError);
    }

    private String fallback(CallNotPermittedException e) {
        String message = "Fallback method called";
        return message + "\n" + e;
    }
}
