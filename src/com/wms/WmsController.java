package com.wms;

import com.wms.app.OrderManager;
import com.wms.model.Order;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WmsController {

    private final OrderManager manager;
    private final OrderProducer producer;

    public WmsController(OrderManager manager, OrderProducer producer) {
        this.manager = manager;
        this.producer = producer;
    }
//
    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable int orderId)
    {
        return manager.findOrder(orderId);
    }

//    @GetMapping("/hello")
//    public String hello() {
//        return "Hello WMS";

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order) {
        try {
            manager.createOrder(order);
            producer.sendOrder(order.getOrderId());
            return ResponseEntity.ok(order);
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(500).body(null);
        }
        }

    @PutMapping("/orders/{orderId}/status")
    public String updateOrderStatus(
            @PathVariable int orderId,
            @RequestParam String status) {

        manager.updateOrderStatus(orderId, status);
        return "Order status updated!";
    }
    }






