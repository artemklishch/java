package org.example;

import java.util.Arrays;

public class Swap {
    public Object[] arguments;

    public Swap(final Object[] args) {
        arguments = args;
    }

    public void swapValues() {
        Object[] args = new Object[]{arguments[0], arguments[1]};
        arguments[0] = args[1];
        arguments[1] = args[0];
    }

    @Override
    public String toString() {
        return "Swap{" +
                "arguments=" + Arrays.toString(arguments) +
                '}';
    }
}
