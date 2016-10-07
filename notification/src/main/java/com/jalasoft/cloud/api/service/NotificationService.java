package com.jalasoft.cloud.api.service;

import com.jalasoft.cloud.api.model.Notification;
import com.jalasoft.cloud.api.repository.StubNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by alejandro on 05-10-16.
 */
@Service
public class NotificationService {

    @Autowired
    private StubNotificationRepository stubNotificationRepository;

    public Observable<Notification> findAll() {
        return Observable.defer(() -> stubNotificationRepository.findAll());
    }

    @Async
    public void create(String message) {
        stubNotificationRepository
                .save(
                         new Notification()
                                .setId(UUID.randomUUID().toString())
                                .setMessage(message)
                                .setTimestamp(LocalDateTime.now())
                );
    }
}