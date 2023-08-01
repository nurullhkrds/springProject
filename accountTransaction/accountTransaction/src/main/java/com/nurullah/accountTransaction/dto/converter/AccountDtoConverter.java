package com.nurullah.accountTransaction.dto.converter;

import com.nurullah.accountTransaction.dto.AccountDto;
import com.nurullah.accountTransaction.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class AccountDtoConverter {

    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;

    public AccountDtoConverter(CustomerDtoConverter customerDtoConverter,
                               TransactionDtoConverter transactionDtoConverter) {
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public AccountDto convert(Account from) {
        return new AccountDto(from.getAccountId(),
                from.getBalance(),
                from.getCreationDate(),
                customerDtoConverter.convertToAccountCustomer(Optional.ofNullable(from.getCustomer())),
                Objects.requireNonNull(from.getTransactions())
                        .stream()
                        .map(transactionDtoConverter::convert)
                        .collect(Collectors.toList()));
    }

}
