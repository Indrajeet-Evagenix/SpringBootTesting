package com.rabbitmq.publisher;

import com.rabbitmq.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQPublisher {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQPublisher.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routingkey.name}")
    private String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Employee employee) {
        log.info("Message Sent-> {}", employee);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, employee);
    }
}
