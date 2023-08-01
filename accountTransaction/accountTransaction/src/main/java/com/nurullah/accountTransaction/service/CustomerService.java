package com.nurullah.accountTransaction.service;

import com.nurullah.accountTransaction.dto.CustomerDto;
import com.nurullah.accountTransaction.dto.converter.CustomerDtoConverter;
import com.nurullah.accountTransaction.exception.CustomerNotFoundException;
import com.nurullah.accountTransaction.model.Customer;
import com.nurullah.accountTransaction.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;


    public CustomerService(CustomerRepository customerRepository,CustomerDtoConverter customerDtoConverter){
        this.customerRepository=customerRepository;
        this.converter=customerDtoConverter;

    }

    protected Customer findCustomerById(String id){

        return customerRepository.findById(id)
                .orElseThrow(()-> new CustomerNotFoundException(id+"Id'ye ait bir Customer yok !"));
    }

    public CustomerDto getCustomerById(String customerId) {
        return converter.convertToCustomerDto(findCustomerById(customerId));

    }
}
