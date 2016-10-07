package com.jalasoft.cloud.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableDiscoveryClient
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication notificationMicroService = new SpringApplication(NotificationApplication.class);
        notificationMicroService.addListeners(new ApplicationPidFileWriter("notification.pid"));
        notificationMicroService.run(args);
    }
}
