package org.example;

public interface NumbersService<T extends Number> {
    T getFromString(String value);
}
