package ru.spb.osiptsoff.finance.crud.dto;

import java.util.UUID;

import org.mapstruct.Mapper;

import ru.spb.osiptsoff.finance.lib.dto.Transaction;

@Mapper(componentModel = "spring", uses = { IdMapper.class })
public interface TransactionDtoConverter extends DtoConverter<UUID, Transaction,
        ru.spb.osiptsoff.finance.crud.model.Transaction> {
    Transaction convertToDto(ru.spb.osiptsoff.finance.crud.model.Transaction object);

    ru.spb.osiptsoff.finance.crud.model.Transaction convertFromDto(Transaction dto);
}
