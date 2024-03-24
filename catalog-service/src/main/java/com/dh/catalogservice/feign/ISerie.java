package com.dh.catalogservice.feign;

import com.dh.catalogservice.Model.DTO.Serie;
import com.dh.catalogservice.configuration.CustomLoadBalancerConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("serie-service")
@LoadBalancerClient(name = "serie-service", configuration = CustomLoadBalancerConfiguration.class)
public interface ISerie {

    @GetMapping("/api/v1/series")
    List<Serie> getAll();

    @GetMapping("/api/v1/series/{genre}")
    List<Serie> getSerieByGenre(@PathVariable String genre);

    @PostMapping("/api/v1/series/create")
    @ResponseStatus(HttpStatus.CREATED)
    String create(@RequestBody Serie serie);

}
