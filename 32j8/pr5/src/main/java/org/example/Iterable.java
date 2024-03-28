package org.example;

public interface Iterable<T> {
    default void printAll() {
        for (T t : getAll()) {
            System.out.println(t);
        }
    }

    ;

    T[] getAll();
}
