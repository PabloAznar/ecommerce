package com.example.ecommerce.notification.infrastructure;

import com.example.ecommerce.notification.application.create.NotificationCreator;
import com.example.ecommerce.notification.application.find.CriteriaNotificationFinder;
import com.example.ecommerce.notification.domain.Notification;
import com.example.ecommerce.shared.domain.Constants;
import com.example.ecommerce.shared.domain.criteria.Criteria;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationPostController {

    private final NotificationCreator notificationCreator;

    private final CriteriaNotificationFinder notificationFinder;

    public NotificationPostController(NotificationCreator notificationCreator, CriteriaNotificationFinder notificationFinder) {
        this.notificationCreator = notificationCreator;
        this.notificationFinder = notificationFinder;
    }

    @PostMapping(Constants.API_BASE_PATH + "/notifications")
    public ResponseEntity create(@RequestBody final Notification notification) {
        this.notificationCreator.create(notification);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping(Constants.API_BASE_PATH + "/notifications/criteria")
    public List<Notification> findByCriteria(@RequestBody final Criteria criteria) {
        return this.notificationFinder.findByCriteria(criteria);
    }

}
