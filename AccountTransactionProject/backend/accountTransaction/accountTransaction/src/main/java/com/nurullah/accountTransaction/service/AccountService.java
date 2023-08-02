package com.nurullah.accountTransaction.service;

import com.nurullah.accountTransaction.dto.AccountDto;
import com.nurullah.accountTransaction.dto.CreateAccountRequest;
import com.nurullah.accountTransaction.dto.converter.AccountDtoConverter;
import com.nurullah.accountTransaction.model.Account;
import com.nurullah.accountTransaction.model.Customer;
import com.nurullah.accountTransaction.model.Transaction;
import com.nurullah.accountTransaction.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter converter;

    public AccountService
            (AccountRepository accountRepository
                    ,CustomerService customerService
            ,AccountDtoConverter accountDtoConverter) {
        this.accountRepository = accountRepository;
        this.customerService=customerService;
        this.converter=accountDtoConverter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer=customerService.findCustomerById(createAccountRequest.getCustomerId());
        Account account=new Account(
                customer,createAccountRequest.getInitialCredit(), LocalDateTime.now());

        if (createAccountRequest.getInitialCredit()>0){
            Transaction transaction=new Transaction(createAccountRequest.getInitialCredit(),account);
            account.getTransactions().add(transaction);
        }

        return converter.convert(accountRepository.save(account));

    }
}
