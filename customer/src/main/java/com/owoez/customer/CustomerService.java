package com.owoez.customer;

import com.owoez.amqp.RabbitMQMessageProducer;
import com.owoez.clients.fraud.FraudCheckResponse;
import com.owoez.clients.fraud.FraudClient;
import com.owoez.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
  private final FraudClient fraudClient;
  private final RabbitMQMessageProducer rabbitMQMessageProducer;

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

	NotificationRequest notificationRequest = new NotificationRequest(customer.getId(), customer.getEmail(),
		"Hi there, this message is to let you know that your account has been created and verified successfully");

	rabbitMQMessageProducer.publish(notificationRequest,
		"internal.exchange",
		"internal.notification.routing-key");
  }
}
