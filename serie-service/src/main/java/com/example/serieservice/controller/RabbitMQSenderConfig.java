package com.example.serieservice.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {
    @Value("${queue.serie.name}")
    private String serieQueue;

    @Bean
    public org.springframework.amqp.core.Queue queue() {
        return new Queue(this.serieQueue, false);
    }
}
