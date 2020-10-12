package com.learning.marketplace.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentGatewayController {

    @GetMapping("/order/{id}")
    public ResponseEntity<String> getOrderById(@PathVariable String id){
        return ResponseEntity.ok("Getting order " + id);
    }

}
