package com.example.serieservice.controller;

import com.example.serieservice.model.Serie;
import com.example.serieservice.service.SerieService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/api/v1/series")
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping
    public List<Serie> getAll() {
        return serieService.getAll();
    }

    @GetMapping("/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {
        return serieService.getSeriesBygGenre(genre);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Serie serie) {
        serieService.create(serie);
        return serie.getId();
    }
}
