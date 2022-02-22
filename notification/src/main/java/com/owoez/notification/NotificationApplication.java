package com.owoez.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author: tobilobaowolabi
 * Date: 22/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/

@SpringBootApplication
@EnableEurekaClient
public class NotificationApplication {
  public static void main(String[] args) {
	SpringApplication.run(NotificationApplication.class, args);
  }
}
