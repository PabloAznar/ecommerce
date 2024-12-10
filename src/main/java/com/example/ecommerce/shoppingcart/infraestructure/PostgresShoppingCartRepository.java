package com.example.ecommerce.shoppingcart.infraestructure;

import com.example.ecommerce.shared.domain.Criteria;
import com.example.ecommerce.shared.exceptions.ECommerceException;
import com.example.ecommerce.shared.exceptions.ExceptionType;
import com.example.ecommerce.shared.infrastructure.HibernateRepository;
import com.example.ecommerce.shoppingcart.domain.ShoppingCart;
import com.example.ecommerce.shoppingcart.domain.ShoppingCartRepository;
import org.hibernate.SessionFactory;
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
    public ShoppingCart findById(String id) {
        return byId(id)
                .orElseThrow(() -> {
                    //log.error("Shopping cart with id {} not found", id);
                    return new ECommerceException(ExceptionType.SHOPPING_CART_NOT_FOUND);
                });
    }

    @Override
    public List<ShoppingCart> findByCriteria(Criteria criteria) {
        return byCriteria(criteria);
    }


}
