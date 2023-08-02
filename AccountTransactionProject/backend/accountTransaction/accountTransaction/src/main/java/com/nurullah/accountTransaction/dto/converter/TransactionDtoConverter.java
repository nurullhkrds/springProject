package com.nurullah.accountTransaction.dto.converter;

import com.nurullah.accountTransaction.dto.TransactionDto;
import com.nurullah.accountTransaction.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public TransactionDto convert(Transaction entity){
        return new TransactionDto(
                entity.getTransactionId(),
                entity.getTransactionType(),
                entity.getAmount(),
                entity.getTransactionDate());
    }


}
