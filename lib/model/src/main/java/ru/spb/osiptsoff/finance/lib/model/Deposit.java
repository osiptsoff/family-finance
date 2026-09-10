package ru.spb.osiptsoff.finance.lib.model;

import lombok.Data;

@Data 
public class Deposit {
    private Target target;
    private Double amount;
    private String description;
}
