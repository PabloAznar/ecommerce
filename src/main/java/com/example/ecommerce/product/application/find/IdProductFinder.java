package com.example.ecommerce.product.application.find;

import com.example.ecommerce.product.domain.Product;
import com.example.ecommerce.product.domain.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class IdProductFinder {

    private final ProductRepository productRepository;

    public IdProductFinder(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product find(final String id) {
        return productRepository.findById(id);
    }
}
