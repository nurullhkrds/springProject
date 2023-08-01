package com.nurullah.accountTransaction.repository;

import com.nurullah.accountTransaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String> {
}
