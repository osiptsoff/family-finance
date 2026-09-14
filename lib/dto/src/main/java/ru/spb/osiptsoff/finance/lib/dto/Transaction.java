package ru.spb.osiptsoff.finance.lib.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class Transaction implements Dto {
    private UUID id;
    private String type;
    private LocalDateTime datetime;
    private Double amount;
    private String description;
}
