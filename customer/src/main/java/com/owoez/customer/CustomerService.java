package com.owoez.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Author: tobilobaowolabi
 * Date: 20/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/

@Service
@AllArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final RestTemplate restTemplate;

  public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
	Customer customer = Customer.builder()
		.firstName(customerRegistrationRequest.firstName())
		.lastName(customerRegistrationRequest.lastName())
		.email(customerRegistrationRequest.email())
		.build();

	customerRepository.saveAndFlush(customer);
	FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());

	if(fraudCheckResponse.isFraudster()){
	  throw new IllegalStateException("Frausdster!!!");
	}

	NotificationRequest notificationRequest = new NotificationRequest(customer.getId(),
		customer.getFirstName() + " " + customer.getLastName(),
		"Hi there, this message is to let you know that your account has been created and verified successfully");

	restTemplate.postForObject("http://NOTIFICATION/api/v1/notification", notificationRequest, String.class);
  }
}
