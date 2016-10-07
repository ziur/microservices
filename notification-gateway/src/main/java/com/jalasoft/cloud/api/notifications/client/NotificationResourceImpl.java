package com.jalasoft.cloud.api.notifications.client;

import com.jalasoft.cloud.api.notifications.model.Notification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationResourceImpl implements NotificationResource {
    
    @Override
    public List<Notification> findAll() {
        return new ArrayList<>();
    }
}
