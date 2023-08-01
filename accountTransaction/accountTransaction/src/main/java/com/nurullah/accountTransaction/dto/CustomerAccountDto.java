package com.nurullah.accountTransaction.dto;


import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class CustomerAccountDto {

    String id;
    int balance;
    List<TransactionDto> transactions;
    LocalDateTime creationDate;


    public CustomerAccountDto(String id, int balance, List<TransactionDto> transactions, LocalDateTime creationDate) {
        this.id = id;
        this.balance = balance;
        this.transactions = transactions;
        this.creationDate = creationDate;
    }


}
