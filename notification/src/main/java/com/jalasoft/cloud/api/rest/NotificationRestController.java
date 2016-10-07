package com.jalasoft.cloud.api.rest;

import com.jalasoft.cloud.api.model.Notification;
import com.jalasoft.cloud.api.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

/**
 * Created by alejandro on 05-10-16.
 */
@RestController
@RequestMapping("/")
public class NotificationRestController {
    @Value("${spring.application.version:0.0.0}")
    private String version;
    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/version")
    public ResponseEntity<String> version() {
        notificationService.create("Someone accessed notification-gateway: /version");
        return ResponseEntity.ok(version);
    }

    @RequestMapping(value = "/notifications", method = RequestMethod.GET)
    public DeferredResult<List<Notification>> notifications() {
        DeferredResult<List<Notification>> notificationDeferredResult = new DeferredResult<>();
        notificationService
                .findAll()
                .toList()
                .subscribe(notificationDeferredResult::setResult);
        return notificationDeferredResult;
    }
}
