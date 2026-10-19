package ru.spb.osiptsoff.finance.crud.dto;

import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

import ru.spb.osiptsoff.finance.crud.model.Deposit;
import ru.spb.osiptsoff.finance.crud.model.Identifiable;
import ru.spb.osiptsoff.finance.crud.model.Target;
import ru.spb.osiptsoff.finance.crud.model.Transaction;

@Component
public class IdMapper {
    private static final Map<Class<?>, Supplier<?>> FACTORIES = Map.of(
        Deposit.class,      Deposit::new,
        Target.class,       Target::new,
        Transaction.class,  Transaction::new
    );

    public Deposit mapIdToDeposit(UUID id) {
        return mapIdToMinObject(id, Deposit.class);
    }

    public UUID mapObjectToId(Deposit object) {
        return mapObjectOrNullToId(object);
    }

    public Target mapIdToTarget(UUID id) {
        return mapIdToMinObject(id, Target.class);
    }

    public UUID mapObjectToId(Target object) {
        return mapObjectOrNullToId(object);
    }

    public Transaction mapIdToTransaction(UUID id) {
        return mapIdToMinObject(id, Transaction.class);
    }

    public UUID mapObjectToId(Transaction object) {
        return mapObjectOrNullToId(object);
    }

    private <T extends Identifiable<UUID>> UUID mapObjectOrNullToId(T object) {
        return object == null ? null : object.getId();
    }

    private <T extends Identifiable<UUID>> T mapIdToMinObject(UUID id, Class<T> clazz) {
        if (id == null) {
            return null;
        }

        T object = (T) FACTORIES.get(clazz).get();
        object.setId(id);
        return object;
    }
}
