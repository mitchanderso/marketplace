package com.learning.marketplace.paymentgateway.controllers;

import com.learning.marketplace.paymentgateway.domain.Order;
import com.learning.marketplace.paymentgateway.model.NewOrderRequest;
import com.learning.marketplace.paymentgateway.model.OrderResponse;
import com.learning.marketplace.paymentgateway.services.OrderService;
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
