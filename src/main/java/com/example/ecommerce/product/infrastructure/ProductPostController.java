package com.example.ecommerce.product.infrastructure;

import com.example.ecommerce.product.application.create.ProductCreator;
import com.example.ecommerce.product.application.find.CriteriaProductFinder;
import com.example.ecommerce.product.domain.Product;
import com.example.ecommerce.shared.domain.Constants;
import com.example.ecommerce.shared.domain.criteria.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductPostController {

    private final ProductCreator productCreator;

    private final CriteriaProductFinder productFinder;

    public ProductPostController(final ProductCreator productCreator, final CriteriaProductFinder productFinder) {
        this.productCreator = productCreator;
        this.productFinder = productFinder;
    }

    @PostMapping(path = Constants.API_BASE_PATH + "/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Product product) {
        this.productCreator.create(product);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping(path = Constants.API_BASE_PATH + "/products/criteria")
    public List<Product> findByCriteria(@RequestBody final Criteria criteria) {
        return this.productFinder.findByCriteria(criteria);
    }

}
