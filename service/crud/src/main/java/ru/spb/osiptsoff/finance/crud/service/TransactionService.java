package ru.spb.osiptsoff.finance.crud.service;

import org.springframework.stereotype.Service;

import ru.spb.osiptsoff.finance.crud.dto.TransactionDtoConverter;
import ru.spb.osiptsoff.finance.crud.repository.TransactionRepository;
import ru.spb.osiptsoff.finance.lib.dto.Transaction;

@Service
public class TransactionService extends MongoCrudService<Transaction, ru.spb.osiptsoff.finance.crud.model.Transaction> {

    public TransactionService(TransactionRepository repository,
            TransactionDtoConverter dtoConversionFactory) {
        super(repository, dtoConversionFactory);
    }
    
}
