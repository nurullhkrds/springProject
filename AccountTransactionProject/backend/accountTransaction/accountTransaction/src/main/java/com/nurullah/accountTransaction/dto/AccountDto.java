package com.nurullah.accountTransaction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
public class AccountDto {

    String accountId;
    int balance;
    LocalDateTime creationDate;
    AccountCustomerDto customer;
    List<TransactionDto> transactions;

    public AccountDto(String accountId, int balance, LocalDateTime creationDate, AccountCustomerDto customer, List<TransactionDto> transactions) {
        this.accountId = accountId;
        this.balance = balance;
        this.creationDate = creationDate;
        this.customer = customer;
        this.transactions = transactions;
    }
}
