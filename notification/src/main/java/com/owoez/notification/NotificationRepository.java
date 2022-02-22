package com.owoez.notification;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: tobilobaowolabi
 * Date: 22/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
