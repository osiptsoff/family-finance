package ru.spb.osiptsoff.finance.lib.dto;

import lombok.Data;

@Data
public class PageRequestDto implements Dto {
    private Integer pageNumber;
    private Integer pageSize;
}
