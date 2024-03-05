package org.example;

public class DoublyLinkedList {
    public static void insertNode(ListNode previous, ListNode newNode) {
        ListNode nextAfterNewNode = previous.next;
        newNode.next = nextAfterNewNode;
        newNode.prev = previous;
        previous.next = newNode;
        nextAfterNewNode.prev = newNode;
    }

    public static void deleteNode(ListNode node) {
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
