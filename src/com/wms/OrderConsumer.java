package com.wms;

import com.wms.app.OrderManager;
import com.wms.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @RabbitListener(queues = "wms.order.queue")
    public void receiveOrder(int orderId) {
        System.out.println("Received order from RabbitMQ: " + orderId);
        manager.updateOrderStatus(orderId, "PROCESSING");
        Order order = manager.findOrder(orderId);

        System.out.println("Order fetched from MySQL: " + order);
    }

    private final OrderManager manager;

    public OrderConsumer(OrderManager manager) {
        this.manager = manager;
    }
}