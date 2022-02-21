package com.owoez.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author: tobilobaowolabi
 * Date: 20/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/

@SpringBootApplication
@EnableEurekaClient
public class FraudApplication {
  public static void main(String[] args) {
	SpringApplication.run(FraudApplication.class, args);
  }
}
