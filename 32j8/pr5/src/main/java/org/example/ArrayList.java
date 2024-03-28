package org.example;

public class ArrayList<T> implements Iterable<T> {
    private T[] values;

    public ArrayList(T[] values) {
        this.values = values;
    }

//    @java.lang.Override
//    public void printAll() {
//        for (T t : values) {
//            System.out.println(t);
//        }
//    }

    @java.lang.Override
    public T[] getAll() {
        return values;
    }
}
