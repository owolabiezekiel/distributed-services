package com.owoez.customer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: tobilobaowolabi
 * Date: 20/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
