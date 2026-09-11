package ru.spb.osiptsoff.finance.lib.model;

import java.util.UUID;

public interface Identifiable {
    UUID getId();
    void setId(UUID id);
}
