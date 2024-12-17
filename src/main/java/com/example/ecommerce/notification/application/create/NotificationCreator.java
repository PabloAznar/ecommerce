package com.example.ecommerce.notification.application.create;

import com.example.ecommerce.notification.domain.Notification;
import com.example.ecommerce.notification.domain.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationCreator {

    private final NotificationRepository notificationRepository;


    public NotificationCreator(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void create(Notification notification) {
        notificationRepository.save(notification);
    }

}
