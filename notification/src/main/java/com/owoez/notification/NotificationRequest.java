package com.owoez.notification;

/**
 * Author: tobilobaowolabi
 * Date: 22/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/
public record NotificationRequest(
	Integer toCustomerId,
	String toCustomerName,
	String message
) {
}
