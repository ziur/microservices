package com.jalasoft.cloud.api.notifications.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient("http://notification")
public interface NotificationVersionResource {

    @RequestMapping(value = "/version", method = GET)
    String version();

}
