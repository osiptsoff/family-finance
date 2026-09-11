package ru.spb.osiptsoff.finance.lib.model;

import java.time.LocalDateTime;

public record Transaction(
    Deposit deposit,
    TransactionType type,
    LocalDateTime datetime,
    Double amount,
    String description
) { }
