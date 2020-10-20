package com.example.rabbitmqproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/produce")
    public void produceMessage(){
        producerService.produceMessage();
        System.out.println("Message produced.");
    }

}
