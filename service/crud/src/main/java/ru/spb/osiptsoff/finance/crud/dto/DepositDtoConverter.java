package ru.spb.osiptsoff.finance.crud.dto;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import ru.spb.osiptsoff.finance.crud.model.Transaction;
import ru.spb.osiptsoff.finance.lib.dto.Deposit;

@Mapper
@Component
public interface DepositDtoConverter extends DtoConverter<UUID, Deposit,
        ru.spb.osiptsoff.finance.crud.model.Deposit> {
    @Mapping(source = "transactionIds", target = "transactions")
    Deposit convertToDto(ru.spb.osiptsoff.finance.crud.model.Deposit object);

    @Mapping(source = "transactions", target = "transactionIds")
    ru.spb.osiptsoff.finance.crud.model.Deposit convertFromDto(Deposit dto);

    default Transaction mapIdToTransaction(UUID id) {
        Transaction transaction = new Transaction();
        transaction.setId(id);
        return transaction;
    }

    default UUID mapTransactionToId(Transaction transaction) {
        return transaction.getId();
    }
    
}
