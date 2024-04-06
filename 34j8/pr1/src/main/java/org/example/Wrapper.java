package org.example;

import java.util.function.Consumer;

public class Wrapper<T> {
    private T value;

    public Wrapper(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static Wrapper<User> empty() {
        return new Wrapper<>(null);
    }

    public boolean isPresent() {
        return value != null;
    }

    public void ifPresent(Consumer<T> consumer) {
        if (value != null) {
            consumer.accept(value);
        }
    }
}
