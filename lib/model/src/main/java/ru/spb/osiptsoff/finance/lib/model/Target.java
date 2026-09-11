package ru.spb.osiptsoff.finance.lib.model;

import java.util.Collection;
import java.util.Currency;

import lombok.Data;

@Data
public class Target {
    private Currency currency;
    private String description;
    private Collection<Deposit> deposits;
}
