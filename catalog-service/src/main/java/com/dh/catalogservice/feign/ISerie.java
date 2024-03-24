package com.dh.catalogservice.feign;

import com.dh.catalogservice.Model.DTO.Serie;
import com.dh.catalogservice.configuration.CustomLoadBalancerConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("serie-service")
@LoadBalancerClient(name = "serie-service", configuration = CustomLoadBalancerConfiguration.class)
public interface ISerie {

    @GetMapping("/api/v1/series")
    ResponseEntity<List<Serie>> getAll();

    @GetMapping("/api/v1/series/{genre}")
    ResponseEntity<List<Serie>> getSerieByGenre(@PathVariable String genre);

    @PostMapping("/api/v1/series/create")
    ResponseEntity<Serie> create(@RequestBody Serie serie);

    @GetMapping("/api/v1/series/test")
    ResponseEntity<String> test();
}
