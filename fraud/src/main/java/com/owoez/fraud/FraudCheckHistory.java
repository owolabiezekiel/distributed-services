package com.owoez.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Author: tobilobaowolabi
 * Date: 20/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckHistory {
  @Id
  @SequenceGenerator(
	  name = "fraud_id_sequence",
	  sequenceName = "fraud_id_sequence"
  )
  @GeneratedValue(
	  strategy = GenerationType.SEQUENCE,
	  generator = "fraud_id_sequence"
  )
  private Integer id;
  private Integer customerId;
  private Boolean isFraudster;
  private LocalDateTime createdAt;
}
