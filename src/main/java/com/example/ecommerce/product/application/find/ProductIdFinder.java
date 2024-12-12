package com.example.ecommerce.product.application.find;

import com.example.ecommerce.product.domain.Product;
import com.example.ecommerce.product.domain.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductIdFinder {

    private final ProductRepository productRepository;

    public ProductIdFinder(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product find(final String id) {
        return productRepository.findById(id);
    }
}
