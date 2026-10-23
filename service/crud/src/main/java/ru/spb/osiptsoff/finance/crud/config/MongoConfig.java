package ru.spb.osiptsoff.finance.crud.config;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertCallback;

import ru.spb.osiptsoff.finance.crud.model.Identifiable;

@Configuration
public class MongoConfig {
    @Bean
    public BeforeConvertCallback<Identifiable<UUID>> beforeSaveCallback() {
        return (document, mutableAggregateChange) -> {
            if (document.getId() == null) {
                document.setId(UUID.randomUUID());
            }
            return document;
        };
    }
}
