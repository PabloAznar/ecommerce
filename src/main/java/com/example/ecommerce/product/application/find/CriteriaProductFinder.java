package com.example.ecommerce.product.application.find;

import com.example.ecommerce.product.domain.Product;
import com.example.ecommerce.product.domain.ProductRepository;
import com.example.ecommerce.shared.domain.criteria.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriteriaProductFinder {

    private final ProductRepository productRepository;

    public CriteriaProductFinder(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findByCriteria(final Criteria criteria) {
        return this.productRepository.findByCriteria(criteria);
    }
}
