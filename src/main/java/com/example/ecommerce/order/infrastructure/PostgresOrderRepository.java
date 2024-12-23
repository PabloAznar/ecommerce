package com.example.ecommerce.order.infrastructure;

import com.example.ecommerce.order.domain.Order;
import com.example.ecommerce.order.domain.OrderRepository;
import com.example.ecommerce.shared.aspects.domain.AspectException;
import com.example.ecommerce.shared.domain.criteria.Criteria;
import com.example.ecommerce.shared.domain.criteria.Filter;
import com.example.ecommerce.shared.domain.errorhandler.exceptions.ECommerceException;
import com.example.ecommerce.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostgresOrderRepository extends HibernateRepository<String, Order> implements OrderRepository {

    public PostgresOrderRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Order.class);
    }

    @Override
    public void save(Order order) {
        persist(order);
    }

    @Override
    @AspectException
    public Order findById(String id) {
        return byId(id)
                .orElseThrow(() ->
                        new ECommerceException(HttpStatus.NOT_FOUND, String.format("Order with id %s not found", id)));
    }

    @Override
    public List<Order> findByUser(final String userId) {
        Filter userFilter = new Filter("user_id", "=", userId);
        Criteria userCriteria = new Criteria(userFilter);
        return byCriteria(userCriteria);
    }
}
