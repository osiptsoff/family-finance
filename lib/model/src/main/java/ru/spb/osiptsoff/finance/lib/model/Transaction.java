package ru.spb.osiptsoff.finance.lib.model;

public record Transaction(
    Deposit deposit,
    TransactionType type,
    Double amount,
    String description
) { }
