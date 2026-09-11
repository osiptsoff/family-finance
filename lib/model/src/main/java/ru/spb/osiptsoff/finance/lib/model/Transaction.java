package ru.spb.osiptsoff.finance.lib.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Transaction(
    @Id UUID id,
    Deposit deposit,
    TransactionType type,
    LocalDateTime datetime,
    Double amount,
    String description
) { }
