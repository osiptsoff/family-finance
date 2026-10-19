package ru.spb.osiptsoff.finance.crud.dto;

import java.util.UUID;

import org.mapstruct.Mapper;

import ru.spb.osiptsoff.finance.lib.dto.Target;

@Mapper(componentModel = "spring", uses = { DepositDtoConverter.class, IdMapper.class })
public interface TargetDtoConverter extends DtoConverter<UUID, Target,
        ru.spb.osiptsoff.finance.crud.model.Target> {
    Target convertToDto(ru.spb.osiptsoff.finance.crud.model.Target object);

    ru.spb.osiptsoff.finance.crud.model.Target convertFromDto(Target dto);
}
