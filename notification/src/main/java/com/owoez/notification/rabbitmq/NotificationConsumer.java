package com.owoez.notification.rabbitmq;

import com.owoez.clients.notification.NotificationRequest;
import com.owoez.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Author: tobilobaowolabi
 * Date: 08/04/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/

@Component
@Slf4j
@AllArgsConstructor
public class NotificationConsumer {
  private final NotificationService notificationService;


  @RabbitListener(queues = "${rabbitmq.queue.notification}")
  public void consumer(NotificationRequest notificationRequest){
	log.info("Consumed {} from queue", notificationRequest);
	notificationService.send(notificationRequest);
  }
}
