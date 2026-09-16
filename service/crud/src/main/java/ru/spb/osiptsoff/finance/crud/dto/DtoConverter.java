package ru.spb.osiptsoff.finance.crud.dto;

import ru.spb.osiptsoff.finance.crud.model.Identifiable;
import ru.spb.osiptsoff.finance.lib.dto.Dto;

/**
 * @param <T> класс Id
 * @param <U> класс Dto
 * @param <V> класс модели
 */
public interface DtoConverter<T, U extends Dto, V extends Identifiable<T>> {
    U convertToDto(V object);
    V convertFromDto(U dto);
}
