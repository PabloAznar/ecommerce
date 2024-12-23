package com.example.ecommerce.shoppingcart.infraestructure;

import com.example.ecommerce.shared.aspects.domain.AspectException;
import com.example.ecommerce.shared.domain.criteria.Criteria;
import com.example.ecommerce.shared.domain.errorhandler.exceptions.ECommerceException;
import com.example.ecommerce.shared.infrastructure.hibernate.HibernateRepository;
import com.example.ecommerce.shoppingcart.domain.ShoppingCart;
import com.example.ecommerce.shoppingcart.domain.ShoppingCartRepository;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostgresShoppingCartRepository extends HibernateRepository<String, ShoppingCart> implements ShoppingCartRepository {

    public PostgresShoppingCartRepository(SessionFactory sessionFactory) {
        super(sessionFactory, ShoppingCart.class);
    }

    @Override
    public void create(ShoppingCart shoppingCart) {
        persist(shoppingCart);
    }

    @Override
    @AspectException
    public ShoppingCart findById(String id) {
        return byId(id)
                .orElseThrow(() ->
                     new ECommerceException(HttpStatus.NOT_FOUND, String.format("Shopping cart with id %s not found", id))
                );
    }

    @Override
    public List<ShoppingCart> findByCriteria(Criteria criteria) {
        return byCriteria(criteria);
    }


}
