package org.example;

public class MyResource implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("Resource was closed");
    }
}
