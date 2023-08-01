package com.nurullah.accountTransaction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    String customerId;
    String name;
    String surname;
    List<CustomerAccountDto> accounts;
}
