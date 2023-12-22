package com.bankofjava.javabank.repository;

import com.bankofjava.javabank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Boolean existsByEmail(String email);
}
