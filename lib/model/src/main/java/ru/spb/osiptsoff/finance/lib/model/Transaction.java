package ru.spb.osiptsoff.finance.lib.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Transaction implements Identifiable {
    @Id
    private UUID id;
    private Deposit deposit;
    private TransactionType type;
    private LocalDateTime datetime;
    private Double amount;
    private String description;
}
