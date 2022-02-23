package com.owoez.customer;

import com.owoez.clients.fraud.FraudCheckResponse;
import com.owoez.clients.fraud.FraudClient;
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
  private final FraudClient fraudClient;

  public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
	Customer customer = Customer.builder()
		.firstName(customerRegistrationRequest.firstName())
		.lastName(customerRegistrationRequest.lastName())
		.email(customerRegistrationRequest.email())
		.build();

	customerRepository.saveAndFlush(customer);
	FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

	if(fraudCheckResponse.isFraudster()){
	  throw new IllegalStateException("Frausdster!!!");
	}

	NotificationRequest notificationRequest = new NotificationRequest(customer.getId(),
		customer.getFirstName() + " " + customer.getLastName(),
		"Hi there, this message is to let you know that your account has been created and verified successfully");

	restTemplate.postForObject("http://NOTIFICATION/api/v1/notification", notificationRequest, String.class);
  }
}
