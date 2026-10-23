package ru.spb.osiptsoff.finance.lib.dto;

public interface IdentifiableDto<T> extends Dto {
    T getId();
    
    void setId(T id);
}
