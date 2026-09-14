package ru.spb.osiptsoff.finance.crud.service;

import ru.spb.osiptsoff.finance.lib.dto.Dto;
import ru.spb.osiptsoff.finance.lib.dto.PageResponseDto;

public interface CrudService<T, U extends Dto> {
    U create(U object);

    PageResponseDto<U> findAll();

    U readById(T id);

    U update(U object);

    void deleteById(T id);
}
