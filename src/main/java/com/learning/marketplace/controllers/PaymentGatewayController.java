package com.learning.marketplace.controllers;

import com.learning.marketplace.domain.Order;
import com.learning.marketplace.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentGatewayController {

    OrderRepository orderRepository;

    public PaymentGatewayController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<String> getOrderById(@PathVariable String id){
        Order order = orderRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return ResponseEntity.ok("The card number was " + order.getCardNumber());
    }

}
