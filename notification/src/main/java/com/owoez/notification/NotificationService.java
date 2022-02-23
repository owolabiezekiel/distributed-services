package com.owoez.notification;

import com.owoez.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Author: tobilobaowolabi
 * Date: 22/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/

@Service
@AllArgsConstructor
public class NotificationService {
  private final NotificationRepository notificationRepository;

  public void send(NotificationRequest notificationRequest) {
	notificationRepository.save(
		Notification.builder()
			.toCustomerId(notificationRequest.toCustomerId())
			.toCustomerEmail(notificationRequest.toCustomerName())
			.sender("TobyJava")
			.message(notificationRequest.message())
			.sentAt(LocalDateTime.now())
			.build()
	);
  }
}
