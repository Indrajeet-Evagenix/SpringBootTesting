package com.rabbitmq.example.publisher;

import com.rabbitmq.example.model.StudentModel;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQProducer {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQProducer.class);
    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

   /* public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }*/

    /*public void sendMessage(String message) {
        log.info("Message Sent -> {}, {}", message, "InsideProducer");
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }*/

    public void sendMessageStudent(StudentModel studentModel) {
        log.info("Message Sent -> {}", studentModel.toString());
        rabbitTemplate.convertAndSend(exchangeName, routingKey, studentModel);
    }
}
