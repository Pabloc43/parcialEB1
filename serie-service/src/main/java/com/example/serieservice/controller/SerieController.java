package com.example.serieservice.controller;

import com.example.serieservice.model.Serie;
import com.example.serieservice.queue.SerieSender;
import com.example.serieservice.service.SerieService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RefreshScope
@RestController
@RequestMapping("/api/v1/series")
public class SerieController {
    private static java.util.logging.Logger log = Logger.getLogger(SerieController.class.getName());

    private final SerieService serieService;

    private final SerieSender senderSerie;

    public SerieController(SerieService serieService, SerieSender senderSerie) {
        this.serieService = serieService;
        this.senderSerie = senderSerie;
    }

    @GetMapping
    public List<Serie> getAll() {
        log.info("Getting all series");
        return serieService.getAll();
    }

    @GetMapping("/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {
        return serieService.getSeriesBygGenre(genre);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveSerie(@RequestBody Serie serie) {
        serieService.save(serie);
        senderSerie.send(serie);
        return serie.getId();
    }
}
