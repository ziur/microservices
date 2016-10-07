package com.jalasoft.cloud.api.notifications.client;

import com.jalasoft.cloud.api.notifications.model.Notification;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(value = "http://notification", fallback = NotificationResourceImpl.class)
public interface NotificationResource {

    @RequestMapping(value = "/notifications", method = GET)
    List<Notification> findAll();


}
