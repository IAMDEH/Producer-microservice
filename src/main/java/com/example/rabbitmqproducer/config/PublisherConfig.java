package com.example.rabbitmqproducer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@Configuration
public class PublisherConfig{

    @Autowired
    Environment env;

    @Bean
    Queue queue() {
        return new Queue(env.getProperty("rabbitmq.queue.name"), false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(env.getProperty("rabbitmq.exchange.name"));
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(env.getProperty("rabbitmq.routingkey"));
    }

    //Required only if you want to pass custom object as part of payload
    @Bean
    public MappingJackson2MessageConverter jackson2Converter() {
        return new MappingJackson2MessageConverter();
    }
}