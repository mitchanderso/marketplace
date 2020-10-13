package com.learning.marketplace.paymentgateway.dataload;

import com.learning.marketplace.paymentgateway.domain.Order;
import com.learning.marketplace.paymentgateway.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DummyDataLoader implements CommandLineRunner {

    private OrderRepository orderRepository;

    public DummyDataLoader(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Order order = new Order("456", "1234567890", "05/21", "AUD", "500" ,"ORD-001");
        orderRepository.save(order);
    }
}
