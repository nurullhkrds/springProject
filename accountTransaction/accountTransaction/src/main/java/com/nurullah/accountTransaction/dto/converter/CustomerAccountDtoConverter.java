package com.nurullah.accountTransaction.dto.converter;

import com.nurullah.accountTransaction.dto.CustomerAccountDto;
import com.nurullah.accountTransaction.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {

    private final TransactionDtoConverter transactionDtoConverter;

    public CustomerAccountDtoConverter(TransactionDtoConverter converter) {
        this.transactionDtoConverter = converter;
    }

    public CustomerAccountDto convert(Account entity) {
        return new CustomerAccountDto(
                Objects.requireNonNull(entity.getAccountId()),
                entity.getBalance(),
                entity.getTransactions()
                        .stream()
                        .map(transactionDtoConverter::convert)
                        .collect(Collectors.toList()),
                entity.getCreationDate());
    }
}
