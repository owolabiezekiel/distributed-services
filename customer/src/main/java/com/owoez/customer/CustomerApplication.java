package com.owoez.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Author: tobilobaowolabi
 * Date: 20/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/

@SpringBootApplication(
    scanBasePackages = {
        "com.owoez.customer",
        "com.owoez.amqp"
    }
)
@EnableEurekaClient
@EnableFeignClients(
    basePackages = "com.owoez.clients"
)

@PropertySources({
    @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class CustomerApplication {
  public static void main(String[] args) {
    SpringApplication.run(CustomerApplication.class, args);
  }
}
