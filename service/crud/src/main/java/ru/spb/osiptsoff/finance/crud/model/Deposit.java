package ru.spb.osiptsoff.finance.crud.model;

import java.util.Collection;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Data;

@Data
public class Deposit implements Identifiable<UUID> {
    @Id 
    private UUID id;
    private Target target;
    private Double amount;
    private String description;
    @DBRef
    private Collection<Transaction> transactions;
}
