package com.owoez.customer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Author: tobilobaowolabi
 * Date: 21/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/

@Configuration
public class CustomerConfig {
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate(){
	return new RestTemplate();
  }
}
