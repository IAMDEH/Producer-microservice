package com.example.rabbitmqproducer.controller;

import com.example.rabbitmqproducer.payload.Notification;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private Environment env;
    @Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;
    @Autowired
    private MappingJackson2MessageConverter mappingJackson2MessageConverter;

    public void produceMessage() {
        Notification notification = new Notification("SMS", "This is an SMS.");
        rabbitMessagingTemplate.setMessageConverter(this.mappingJackson2MessageConverter);
        rabbitMessagingTemplate.convertAndSend(env.getProperty("rabbitmq.exchange.name"), env.getProperty("rabbitmq.routingkey"), notification);
    }
}
