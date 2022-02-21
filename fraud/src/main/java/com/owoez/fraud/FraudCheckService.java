package com.owoez.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Author: tobilobaowolabi
 * Date: 20/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/

@Service
public class FraudCheckService {
  private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

  public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
	this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
  }

  public boolean isFraudulentCustomer(Integer customerId){
	fraudCheckHistoryRepository.save(
		FraudCheckHistory.builder()
			.customerId(customerId)
			.isFraudster(false)
			.createdAt(LocalDateTime.now())
			.build());
	return false;
  }
}
