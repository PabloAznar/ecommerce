package com.example.ecommerce.notification.application.find;

import com.example.ecommerce.notification.domain.Notification;
import com.example.ecommerce.notification.domain.NotificationRepository;
import com.example.ecommerce.shared.domain.criteria.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriteriaNotificationFinder {

    private final NotificationRepository notificationRepository;

    public CriteriaNotificationFinder(final NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> findByCriteria(final Criteria criteria) {
        return notificationRepository.findByCriteria(criteria);
    }
}
