package com.owoez.notification;

import com.owoez.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * Author: tobilobaowolabi
 * Date: 22/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/

@SpringBootApplication(
	scanBasePackages = {
		"com.owoez.notification",
		"com.owoez.amqp"
	}
)
@EnableEurekaClient
public class NotificationApplication {
  public static void main(String[] args) {
	SpringApplication.run(NotificationApplication.class, args);
  }

//  @Bean
//  CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig){
//	return args -> {
//	  producer.publish(new Person("Tobiloba", 20), notificationConfig.getInternalExchange(), notificationConfig.getInternalNotificationRoutingKey());
//	};
//  }
//
//  record Person(String name, int age){}
}
