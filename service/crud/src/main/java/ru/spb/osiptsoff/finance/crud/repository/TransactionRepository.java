package ru.spb.osiptsoff.finance.crud.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import ru.spb.osiptsoff.finance.lib.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, UUID> {
    
}
