package com.nurullah.accountTransaction.dto.converter;

import com.nurullah.accountTransaction.dto.AccountCustomerDto;
import com.nurullah.accountTransaction.dto.CustomerDto;
import com.nurullah.accountTransaction.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {


    private final CustomerAccountDtoConverter customerAccountDtoConverter;

    public CustomerDtoConverter(CustomerAccountDtoConverter converter) {
        this.customerAccountDtoConverter = converter;
    }

    public AccountCustomerDto convertToAccountCustomer(Optional<Customer> from) {
        return from.map(f -> new AccountCustomerDto(f.getCustomerId(), f.getName(), f.getSurname())).orElse(null);
    }

    public CustomerDto convertToCustomerDto(Customer from) {
        return new CustomerDto(
                from.getCustomerId(),
                from.getName(),
                from.getSurname(),
                from.getAccounts()
                        .stream()
                        .map(customerAccountDtoConverter::convert)
                        .collect(Collectors.toList()));

    }
}
