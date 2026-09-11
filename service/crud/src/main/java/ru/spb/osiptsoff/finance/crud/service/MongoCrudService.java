package ru.spb.osiptsoff.finance.crud.service;

import java.util.Collection;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import lombok.RequiredArgsConstructor;
import ru.spb.osiptsoff.finance.lib.model.Identifiable;

@RequiredArgsConstructor
public abstract class MongoCrudService<T extends Identifiable> {
    private final MongoRepository<T, UUID> repository;

    public T create(T object) {
        if (object.getId() != null && repository.existsById(object.getId())) {
            // todo create and use custom exceptions
            throw new RuntimeException("Object exists already.");
        }

        return upsert(object);
    }

    // todo pagination
    public Collection<T> readAll() {
        return repository.findAll();
    }

    public T readById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public T update(T object) {
        if (object.getId() == null || !repository.existsById(object.getId())) {
            // todo create and use custom exceptions
            throw new RuntimeException("Object does not exists or missing id");
        }

        return upsert(object);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private T upsert(T object) {
        return repository.insert(object);
    }
}
