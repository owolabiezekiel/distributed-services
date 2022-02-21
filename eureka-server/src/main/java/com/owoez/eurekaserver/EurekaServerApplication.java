package com.owoez.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Author: tobilobaowolabi
 * Date: 21/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
  public static void main(String[] args) {
	SpringApplication.run(EurekaServerApplication.class, args);
  }
}
