package com.example.ecommerce.shoppingcart.domain;

import com.example.ecommerce.shared.domain.Criteria;

import java.util.List;

public interface ShoppingCartRepository {

    void create(ShoppingCart shoppingCart);

    ShoppingCart findById(String id);

    List<ShoppingCart> findByCriteria(Criteria criteria);
}
