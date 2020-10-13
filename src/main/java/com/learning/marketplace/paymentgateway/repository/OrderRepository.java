package com.learning.marketplace.paymentgateway.repository;

import com.learning.marketplace.paymentgateway.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {
}
