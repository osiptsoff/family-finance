package ru.spb.osiptsoff.finance.lib.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDto implements Dto {
    private Integer pageNumber;
    private Integer pageSize;
}
