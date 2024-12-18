package com.example.ecommerce.notification.application.find;

import com.example.ecommerce.notification.domain.Notification;
import com.example.ecommerce.notification.domain.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class IdNotificationFinder {

    private final NotificationRepository notificationRepository;

    public IdNotificationFinder(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification findById(final String id) {
        return notificationRepository.findById(id);
    }

}
