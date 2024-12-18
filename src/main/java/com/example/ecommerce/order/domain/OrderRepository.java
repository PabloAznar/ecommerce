package com.example.ecommerce.order.domain;

import java.util.List;

public interface OrderRepository {

    void save(Order order);

    Order findById(String id);

    List<Order> findByUser(String userId);
}
