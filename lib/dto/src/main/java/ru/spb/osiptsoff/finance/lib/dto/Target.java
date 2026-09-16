package ru.spb.osiptsoff.finance.lib.dto;

import java.util.Collection;
import java.util.Currency;
import java.util.UUID;

import lombok.Data;

@Data
public class Target implements Dto {
    private UUID id;
    private Currency currency;
    private String description;
    private Collection<Deposit> deposits;
}
