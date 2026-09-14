package ru.spb.osiptsoff.finance.crud.model;

import java.util.Collection;
import java.util.Currency;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Target implements Identifiable<UUID> {
    @Id
    private UUID id;
    private Currency currency;
    private String description;
    private Collection<Deposit> deposits;
}
