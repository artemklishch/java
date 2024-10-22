package org.example.pr21;

import java.util.concurrent.Callable;

public class StringLength implements Callable<Integer> {
    private final String value;

    public StringLength(String value) {
        this.value = value;
    }

    @Override
    public Integer call() {
        return value.length();
    }
}
