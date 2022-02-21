package com.owoez.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Author: tobilobaowolabi
 * Date: 20/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/

@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudCheckController {
  private final FraudCheckService fraudCheckService;

  @GetMapping(path = "{customerId}")
  public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
	boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
	log.info("Fraud check request for customer: {}", customerId);
	return new FraudCheckResponse(isFraudulentCustomer);
  }
}
