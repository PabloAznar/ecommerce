package com.example.ecommerce.product.domain;

import com.example.ecommerce.shared.domain.criteria.Criteria;

import java.util.List;

public interface ProductRepository {

    void save(Product product);

    Product findById(String producId);

    List<Product> findByCriteria(Criteria criteria);
}
