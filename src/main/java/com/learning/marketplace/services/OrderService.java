package com.learning.marketplace.services;

import com.learning.marketplace.domain.Order;
import com.learning.marketplace.error.OrderNotFoundException;
import com.learning.marketplace.model.BankOrderResponse;
import com.learning.marketplace.model.NewOrderRequest;
import com.learning.marketplace.model.OrderResponse;
import com.learning.marketplace.repository.OrderRepository;
import com.learning.marketplace.utils.OrderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    OrderRepository orderRepository;
    DummyBank dummyBank;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        dummyBank = new DummyBank();
    }

    @Transactional
    public Order save(NewOrderRequest newOrderRequest) {
        BankOrderResponse bankOrderResponse = dummyBank.processOrderSuccessfully(newOrderRequest);

        // Try and call the bank
        Order order = new Order(newOrderRequest.getCvv(), newOrderRequest.getCardNumber(), newOrderRequest.getExpiryDate(), newOrderRequest.getCurrency(), newOrderRequest.getAmount());
        order.setOrderStatus(bankOrderResponse.getOrderStatus());
        order.setId(bankOrderResponse.getOrderId());
        orderRepository.save(order);
        return order;
        // Store the request
    }

    public OrderResponse getOrderById(String id){
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        OrderResponse orderResponse = new OrderResponse(OrderUtils.obfuscateCardNumber(order.getCardNumber()), order.getOrderStatus(), order.getExpiryDate());
        return orderResponse;
    }
}
