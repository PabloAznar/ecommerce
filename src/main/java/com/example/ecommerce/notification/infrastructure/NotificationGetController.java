package com.example.ecommerce.notification.infrastructure;

import com.example.ecommerce.notification.application.find.IdNotificationFinder;
import com.example.ecommerce.notification.domain.Notification;
import com.example.ecommerce.shared.domain.Constants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationGetController {

    private final IdNotificationFinder notificationFinder;

    public NotificationGetController(IdNotificationFinder notificationFinder) {
        this.notificationFinder = notificationFinder;
    }

    @GetMapping(path = Constants.API_BASE_PATH + "/notifications/{id}")
    public Notification findById(@PathVariable("id") final String id) {
        return notificationFinder.findById(id);
    }

}
