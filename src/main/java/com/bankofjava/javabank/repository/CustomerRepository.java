package com.bankofjava.javabank.repository;

import com.bankofjava.javabank.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerDetails, Long> {
}
