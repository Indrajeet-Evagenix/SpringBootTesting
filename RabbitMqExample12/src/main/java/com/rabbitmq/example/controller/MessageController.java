package com.rabbitmq.example.controller;

import com.rabbitmq.example.model.StudentModel;
import com.rabbitmq.example.publisher.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageController {

    //@Autowired
    private RabbitMQProducer rabbitMQProducer;

    public MessageController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    /*@GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ...");
    }*/

    @GetMapping("/student")
    public ResponseEntity<String> sendMessageStudent(@RequestBody StudentModel studentModel) {
        rabbitMQProducer.sendMessageStudent(studentModel);
        System.out.println(studentModel);
        return ResponseEntity.ok("Message sent to RabbitMQ StudentModel...");
    }
}
