package com.learning.marketplace.controllers;

import com.learning.marketplace.domain.Order;
import com.learning.marketplace.model.NewOrderRequest;
import com.learning.marketplace.model.OrderResponse;
import com.learning.marketplace.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentGatewayController {

    OrderService orderService;

    public PaymentGatewayController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable String id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody NewOrderRequest newOrderRequest){
        return ResponseEntity.ok(orderService.save(newOrderRequest));
    }

}
