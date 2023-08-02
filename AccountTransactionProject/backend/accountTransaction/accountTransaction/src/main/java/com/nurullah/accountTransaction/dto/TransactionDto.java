package com.nurullah.accountTransaction.dto;

import com.nurullah.accountTransaction.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    String transactionId;
    TransactionType transactionType=TransactionType.INITIAL;
    int amount;
    LocalDateTime transactionDate;
}
