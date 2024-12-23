package com.example.ecommerce.product.infrastructure;

import com.example.ecommerce.product.domain.Product;
import com.example.ecommerce.product.domain.ProductRepository;
import com.example.ecommerce.shared.aspects.domain.AspectException;
import com.example.ecommerce.shared.domain.criteria.Criteria;
import com.example.ecommerce.shared.domain.errorhandler.exceptions.ECommerceException;
import com.example.ecommerce.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostgresProductRepository extends HibernateRepository<String, Product> implements ProductRepository {

    public PostgresProductRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Product.class);
    }

    @Override
    public void save(Product product) {
        persist(product);
    }

    @Override
    @AspectException
    public Product findById(String producId) {
        return byId(producId)
                .orElseThrow(() ->
                        new ECommerceException(HttpStatus.NOT_FOUND, String.format("Product with id %s not found", producId)));
    }

    @Override
    public List<Product> findByCriteria(Criteria criteria) {
        return byCriteria(criteria);
    }
}
