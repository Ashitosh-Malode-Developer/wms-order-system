package com.wms;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {

    private final RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(int orderId) {
        System.out.println("Sending order to RabbitMQ: " + orderId);
        rabbitTemplate.convertAndSend("wms.order.queue", orderId);
    }
}