package ru.spb.osiptsoff.finance.crud.dto;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ru.spb.osiptsoff.finance.crud.model.Deposit;
import ru.spb.osiptsoff.finance.lib.dto.Target;

@Mapper 
public interface TargetDtoConverter extends DtoConverter<UUID, Target,
        ru.spb.osiptsoff.finance.crud.model.Target> {
    @Mapping(source = "deposits", target = "depositIds")
    Target convertToDto(ru.spb.osiptsoff.finance.crud.model.Target object);

    @Mapping(source = "depositIds", target = "depositIds")
    ru.spb.osiptsoff.finance.crud.model.Target convertFromDto(Target dto);

    default Deposit mapIdToTransaction(UUID id) {
        Deposit deposit = new Deposit();
        deposit.setId(id);
        return deposit;
    }

    default UUID mapTransactionToId(Deposit deposit) {
        return deposit.getId();
    }
}
