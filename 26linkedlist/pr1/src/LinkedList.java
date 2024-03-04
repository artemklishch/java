public class LinkedList {
    private Node<T> head;
    private Node<T> tail;

    public void add(T value) {
//        new Node<>(prev, value, next);
    }

    class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(Node<T> prev, T value, Node<T> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
