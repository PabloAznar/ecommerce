package com.example.ecommerce.product.application.create;

import com.example.ecommerce.product.domain.Product;
import com.example.ecommerce.product.domain.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCreator {

    private final ProductRepository productRepository;

    public ProductCreator(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void create(Product product) {
        productRepository.save(product);
    }
}
