package com.example.ecommerce.notification.infrastructure;

import com.example.ecommerce.notification.domain.Notification;
import com.example.ecommerce.notification.domain.NotificationRepository;
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
public class PostgresNotificationRepository extends HibernateRepository<String, Notification> implements NotificationRepository {

    public PostgresNotificationRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Notification.class);
    }

    @Override
    public void save(Notification notification) {
        this.persist(notification);
    }

    @Override
    @AspectException
    public Notification findById(String id) {
        return this.byId(id)
                .orElseThrow(() ->
                        new ECommerceException(HttpStatus.NOT_FOUND, String.format("Notification with id %s not found", id))
                );
    }

    @Override
    public List<Notification> findByCriteria(Criteria criteria) {
        return this.byCriteria(criteria);
    }
}
