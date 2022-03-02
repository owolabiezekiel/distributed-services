package com.owoez.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author: tobilobaowolabi
 * Date: 02/03/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/
@EnableEurekaClient
@SpringBootApplication
public class ApiGatewayApplication {
  public static void main(String[] args) {
	SpringApplication.run(ApiGatewayApplication.class, args);
  }
}
