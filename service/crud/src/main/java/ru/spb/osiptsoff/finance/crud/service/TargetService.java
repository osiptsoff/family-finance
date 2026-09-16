package ru.spb.osiptsoff.finance.crud.service;

import org.springframework.stereotype.Service;

import ru.spb.osiptsoff.finance.crud.dto.TargetDtoConverter;
import ru.spb.osiptsoff.finance.crud.repository.TargetRepository;
import ru.spb.osiptsoff.finance.lib.dto.Target;

@Service
public class TargetService extends MongoCrudService<Target, ru.spb.osiptsoff.finance.crud.model.Target> {

    public TargetService(TargetRepository repository,
            TargetDtoConverter dtoConversionFactory) {
        super(repository, dtoConversionFactory);
    }
    
}
