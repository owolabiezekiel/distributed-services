package com.owoez.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Author: tobilobaowolabi
 * Date: 22/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/

@FeignClient("fraud")
public interface FraudClient {
  @GetMapping(path = "/api/v1/fraud-check/{customerId}")
  FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);
}
