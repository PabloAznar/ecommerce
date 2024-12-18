package com.example.ecommerce.notification.infrastructure;

import com.example.ecommerce.notification.domain.Notification;
import com.example.ecommerce.notification.domain.NotificationRepository;
import com.example.ecommerce.shared.domain.criteria.Criteria;
import com.example.ecommerce.shared.domain.errorhandler.exceptions.ECommerceException;
import com.example.ecommerce.shared.domain.errorhandler.exceptions.ExceptionType;
import com.example.ecommerce.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
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
    public Notification findById(String id) {
        return this.byId(id)
                .orElseThrow(() -> {
                    return new ECommerceException(ExceptionType.NOTIFICATION_NOT_FOUND);
                });
    }

    @Override
    public List<Notification> findByCriteria(Criteria criteria) {
        return this.byCriteria(criteria);
    }
}
