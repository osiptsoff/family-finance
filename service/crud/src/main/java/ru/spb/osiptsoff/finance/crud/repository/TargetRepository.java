package ru.spb.osiptsoff.finance.crud.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import ru.spb.osiptsoff.finance.crud.model.Target;

public interface TargetRepository extends MongoRepository<Target, UUID> {
    
}
