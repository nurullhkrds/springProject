package com.nurullah.accountTransaction.repository;

import com.nurullah.accountTransaction.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
