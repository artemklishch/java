package org.example;

public class Main {
    public static void main(String[] args) {
        // Inner classes

        // Static nested classes (fe, Builder pattern)
        // Non-Static inner classes (Node for LinkedList)
        // Local classes (defined in methods)
        // Anonymous classes (Comparator)

        LinkedList linkedList = new LinkedList();
        LinkedList.Node node = linkedList.new Node();
        linkedList.setKey("KEY");
        node.setValue("VALUE");
        System.out.println(node.toString());

        class Local {
            private String type;

            public java.lang.String getType() {
                return type;
            }

            public void setType(java.lang.String type) {
                this.type = type;
            }

            @java.lang.Override
            public java.lang.String toString() {
                return "Local{" +
                        "type=" + type +
                        '}';
            }
        }

        Local local = new Local();
        local.setType("Java");
        System.out.println(local.toString());
    }

    public static void test() {
//        Local local = new Local();
    }
}