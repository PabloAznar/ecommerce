package com.example.ecommerce.notification.domain;

import com.example.ecommerce.shared.domain.criteria.Criteria;

import java.util.List;

public interface NotificationRepository {

    void save(Notification notification);

    Notification findById(String id);

    List<Notification> findByCriteria(Criteria criteria);

}
