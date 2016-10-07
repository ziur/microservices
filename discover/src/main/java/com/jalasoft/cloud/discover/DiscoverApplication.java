package com.jalasoft.cloud.discover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoverApplication {
    public static void main(String[] args) {
        SpringApplication eurekaServer = new SpringApplication(DiscoverApplication.class);
        eurekaServer.addListeners(new ApplicationPidFileWriter("discover.pid"));
        eurekaServer.run(args);
    }
}
