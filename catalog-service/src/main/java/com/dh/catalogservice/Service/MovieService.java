package com.dh.catalogservice.Service;

import com.dh.catalogservice.Model.DTO.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll(Boolean value);
}
