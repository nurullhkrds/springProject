package com.nurullah.accountTransaction.repository;

import com.nurullah.accountTransaction.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
