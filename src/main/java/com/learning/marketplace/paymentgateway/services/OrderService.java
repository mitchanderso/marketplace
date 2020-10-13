package com.learning.marketplace.paymentgateway.services;

import com.learning.marketplace.paymentgateway.domain.Order;
import com.learning.marketplace.paymentgateway.error.BankUnresponsiveException;
import com.learning.marketplace.paymentgateway.error.OrderNotFoundException;
import com.learning.marketplace.paymentgateway.model.BankOrderResponse;
import com.learning.marketplace.paymentgateway.model.NewOrderRequest;
import com.learning.marketplace.paymentgateway.model.OrderResponse;
import com.learning.marketplace.paymentgateway.repository.OrderRepository;
import com.learning.marketplace.paymentgateway.utils.OrderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {


    RestTemplate restTemplate;
    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    BankOrderResponse getBankOrderResponse(NewOrderRequest newOrderRequest) throws RestClientException{
        return restTemplate.postForEntity("http://localhost:8080/execufteOrder", newOrderRequest, BankOrderResponse.class).getBody();
    }

    @Transactional
    public Order save(NewOrderRequest newOrderRequest) {
        try {
            BankOrderResponse bankOrderResponse =  getBankOrderResponse(newOrderRequest);
            Order order = new Order(newOrderRequest.getCvv(), newOrderRequest.getCardNumber(), newOrderRequest.getExpiryDate(), newOrderRequest.getCurrency(), newOrderRequest.getAmount());
            order.setOrderStatus(bankOrderResponse.getOrderStatus());
            order.setId(bankOrderResponse.getOrderId());
            orderRepository.save(order);
            return order;
        } catch (RestClientException e){
            // Log the client exception here
            throw new BankUnresponsiveException("BANK UNRESPONSIVE");
        }

        // Store the request
    }

    public OrderResponse getOrderById(String id){
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        OrderResponse orderResponse = new OrderResponse(OrderUtils.obfuscateCardNumber(order.getCardNumber()), order.getOrderStatus(), order.getExpiryDate());
        return orderResponse;
    }
}
