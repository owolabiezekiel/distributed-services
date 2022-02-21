package com.owoez.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
public class Customer {
  @Id
  @SequenceGenerator(
      name = "customer_id_sequence",
      sequenceName = "customer_id_sequence"
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "customer_id_sequence"
  )
  private Integer id;
  private String firstName;
  private String lastName;
  private String email;
}
