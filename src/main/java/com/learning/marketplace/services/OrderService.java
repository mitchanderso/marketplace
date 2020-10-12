package com.learning.marketplace.services;

import com.learning.marketplace.domain.Order;
import com.learning.marketplace.model.NewOrderRequest;
import com.learning.marketplace.model.OrderResponse;
import com.learning.marketplace.repository.OrderRepository;
import com.learning.marketplace.utils.OrderUtils;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(NewOrderRequest newOrderRequest) {
        // Try and call the bank
        // Store the request
    }

    public OrderResponse getOrderById(String id){
        Order order = orderRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        OrderResponse orderResponse = new OrderResponse(OrderUtils.obfuscateCardNumber(order.getCardNumber()), order.getOrderStatus(), order.getExpiryDate());
        return orderResponse;
    }
}
