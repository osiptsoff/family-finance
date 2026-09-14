package ru.spb.osiptsoff.finance.crud.model;

public interface Identifiable<T> {
    T getId();
    void setId(T id);
}
