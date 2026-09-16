package ru.spb.osiptsoff.finance.crud.dto;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ru.spb.osiptsoff.finance.lib.dto.Deposit;
import ru.spb.osiptsoff.finance.lib.dto.Target;

@Mapper
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired ))
public abstract class TargetDtoConverter implements DtoConverter<UUID, Target,
        ru.spb.osiptsoff.finance.crud.model.Target> {
    private final DepositDtoConverter depositDtoConverter;

    public abstract Target convertToDto(ru.spb.osiptsoff.finance.crud.model.Target object);

    public abstract ru.spb.osiptsoff.finance.crud.model.Target convertFromDto(Target dto);

    protected Deposit mapDepositDtoToModel(ru.spb.osiptsoff.finance.crud.model.Deposit model) {
        return depositDtoConverter.convertToDto(model);
    }

    protected ru.spb.osiptsoff.finance.crud.model.Deposit mapDepositModelToDto(Deposit dto) {
        return depositDtoConverter.convertFromDto(dto);
    }
}
