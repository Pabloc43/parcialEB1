package com.dh.catalogservice.queue;

import com.dh.catalogservice.Model.DTO.Movie;
import com.dh.catalogservice.Model.DTO.Serie;
import com.dh.catalogservice.feign.IMovie;
import com.dh.catalogservice.feign.ISerie;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CatalogListener {
    private ISerie serieService;
    private IMovie movieService;

    @Bean
    @Primary
    public Jackson2JsonMessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

//    @RabbitListener(queues = {"${queue.serie.name}"})
//    public void receive(@Payload Serie serie){
//        serieService.create(serie);
//    }

    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receive(@Payload Movie movie){
//        movieService.saveMovie(movie);
    }
}
