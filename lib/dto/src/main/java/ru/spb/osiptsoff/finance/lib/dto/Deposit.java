package ru.spb.osiptsoff.finance.lib.dto;

import java.util.Collection;
import java.util.UUID;

import lombok.Data;

@Data 
public class Deposit implements Dto {
    private UUID id;
    private UUID targetId;
    private Double amount;
    private String description;
    private Collection<UUID> transactionIds;
}
