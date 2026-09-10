package ru.spb.osiptsoff.finance.lib.model;

import lombok.Data;

@Data 
public class Transaction {
    private Deposit deposit;
    private TransactionType transactionType;
    private Double amount;
    private String description;
}
