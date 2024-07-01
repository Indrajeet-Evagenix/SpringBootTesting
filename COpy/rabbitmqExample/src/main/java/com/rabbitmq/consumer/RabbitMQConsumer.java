package com.rabbitmq.consumer;

import com.rabbitmq.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQConsumer {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(bindings = @QueueBinding(value =
    @Queue(value = "${rabbitmq.queue.name}",durable = "true"),
            exchange = @Exchange(value = "${rabbitmq.exchange.name}",
                    type = "topic"),key = "${rabbitmq.routingkey.name}"))
    public void consumeMessage(Employee employee) {
        log.info("Message Received-> {}", employee);
    }
}
