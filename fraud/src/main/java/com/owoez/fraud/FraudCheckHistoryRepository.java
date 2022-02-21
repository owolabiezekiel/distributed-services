package com.owoez.fraud;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: tobilobaowolabi
 * Date: 20/02/2022
 * Project: distributed-services
 * IDE: IntelliJ IDEA
 **/
public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
