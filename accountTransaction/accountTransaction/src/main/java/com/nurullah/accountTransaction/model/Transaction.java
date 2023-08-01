package com.nurullah.accountTransaction.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String transactionId;

    private TransactionType transactionType=TransactionType.INITIAL;

    private int amount;
    private LocalDateTime transactionDate;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Transaction(Integer amount, Account account) {
        transactionId=null;
        this.amount=amount;
        this.account=account;
        transactionType=TransactionType.INITIAL;
        transactionDate= LocalDateTime.now();


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction that)) return false;
        return amount == that.amount && Objects.equals(transactionId, that.transactionId) && transactionType == that.transactionType && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, transactionType, amount, transactionDate, account);
    }
}

