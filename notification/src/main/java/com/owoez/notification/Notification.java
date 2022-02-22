package com.owoez.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Author: tobilobaowolabi
 * Date: 22/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
  @Id
  @SequenceGenerator(
	  name = "notification_id_sequence",
	  sequenceName = "notification_id_sequence"
  )
  @GeneratedValue(
	  strategy = GenerationType.SEQUENCE,
	  generator = "notification_id_sequence"
  )
  private Integer notificationId;
  private Integer toCustomerId;
  private String toCustomerEmail;
  private String sender;
  private String message;
  private LocalDateTime sentAt;
}
