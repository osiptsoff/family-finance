package ru.spb.osiptsoff.finance.crud.dto;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ru.spb.osiptsoff.finance.lib.dto.Deposit;

@Mapper(componentModel = "spring", uses = { IdMapper.class })
public interface DepositDtoConverter extends DtoConverter<UUID, Deposit,
        ru.spb.osiptsoff.finance.crud.model.Deposit> {
    @Mapping(source = "transactions", target = "transactionIds")
    Deposit convertToDto(ru.spb.osiptsoff.finance.crud.model.Deposit object);

    @Mapping(source = "transactionIds", target = "transactions")
    ru.spb.osiptsoff.finance.crud.model.Deposit convertFromDto(Deposit dto);
}
