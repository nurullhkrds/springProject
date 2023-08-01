package com.nurullah.accountTransaction.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String accountId;
    private int balance;
    private LocalDateTime creationDate;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Transaction> transactions;


    public Account(Customer customer, int initialCredit, LocalDateTime now) {
        this.accountId=null;
        this.transactions=getTransactions();
        this.customer=customer;
        this.balance=initialCredit;
        this.creationDate=now;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return balance == account.balance && Objects.equals(accountId, account.accountId) && Objects.equals(creationDate, account.creationDate) && Objects.equals(customer, account.customer) && Objects.equals(transactions, account.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, balance, creationDate, customer, transactions);
    }
}
