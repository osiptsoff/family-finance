package ru.spb.osiptsoff.finance.lib.dto;

import java.util.Collection;

import lombok.Data;

@Data 
public class PageResponseDto<T extends Dto> {
    private Integer pages;
    private Integer size;
    private Collection<T> content;
}
