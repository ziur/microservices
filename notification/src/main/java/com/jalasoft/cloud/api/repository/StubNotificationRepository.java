package com.jalasoft.cloud.api.repository;

import com.google.common.collect.Sets;
import com.jalasoft.cloud.api.model.Notification;
import org.springframework.stereotype.Repository;
import rx.Observable;

import java.util.Set;

/**
 * Created by alejandro on 05-10-16.
 */
@Repository
public class StubNotificationRepository {

    private Set<Notification> notificationList = Sets.newConcurrentHashSet();

    public Observable<Notification> findAll() {
        return Observable.from(notificationList);
    }

    public void save(Notification notification) {
        notificationList.add(notification);
    }

}

