package com.rabbitmq.controller;

import com.rabbitmq.model.Employee;
import com.rabbitmq.publisher.RabbitMQPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RabbitMQController {

    @Autowired
    private RabbitMQPublisher rabbitMQPublisher;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessageController(@RequestBody Employee employee) {
        rabbitMQPublisher.sendMessage(employee);
        System.out.println(employee);
        return ResponseEntity.ok("Message Sent to RabbitMQ");
    }
}
