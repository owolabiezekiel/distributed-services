package com.owoez.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Author: tobilobaowolabi
 * Date: 23/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/

@FeignClient("notification")
public interface NotificationClient {
  @PostMapping("/api/v1/notification")
  void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
