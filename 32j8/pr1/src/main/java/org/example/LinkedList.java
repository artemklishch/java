package org.example;

public class LinkedList {
    private String key;

    public java.lang.String getKey() {
        return key;
    }

    public void setKey(java.lang.String key) {
        this.key = key;
    }

    //    public static class Node {
    public class Node {
        private String value;

        public java.lang.String getValue() {
            return value;
        }

        public void setValue(java.lang.String value) {
            this.value = value;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "Node{" +
                    "value=" + value +
                    "key=" + key + // if class is static - no access to the parent class field
                    '}';
        }
    }
}
