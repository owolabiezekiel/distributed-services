package com.owoez.notification;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: tobilobaowolabi
 * Date: 22/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/

@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
@Slf4j
public class NotificationController {
  private final NotificationService notificationService;

  @PostMapping
  public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
	log.info("New notification... {}", notificationRequest);
	notificationService.send(notificationRequest);
  }
}
