package org.example.doubly;

public class Main {
    public static void main(String[] args) {

        DoublyLinkedList doublyLL = new DoublyLinkedList();
        doublyLL.addFirst(11);
        doublyLL.addFirst(21);
        doublyLL.addFirst(31);
        doublyLL.addFirst(41);
        doublyLL.addFirst(51);

        System.out.println("\nDoubly LinkedList: ");
        doublyLL.display();
        System.out.println("\nReversed LinkedList Display: ");
        doublyLL.reverseDisplay();

        System.out.println("\nCount: ");
        System.out.println(doublyLL.count());

        System.out.println("\nDeleting first: ");
        doublyLL.deleteFirst();
        doublyLL.display();

        System.out.println("\nAdding Last: ");
        doublyLL.addLast(61);
        doublyLL.display();

        System.out.println("\nDeleting last: ");
        doublyLL.deleteLast();
        doublyLL.display();

        System.out.println("\nAdding at index 3: ");
        doublyLL.addAtIndex(3,71);
        doublyLL.display();

        System.out.println("\nDeleting at index 4: ");
        doublyLL.deleteAtIndex(4);
        doublyLL.display();

        System.out.println("\nCount: ");
        System.out.println(doublyLL.count());

        System.out.println("\nReversing Linked List: ");
        doublyLL.reverseLL();
        doublyLL.display();

        System.out.println("\nReversing Linked List: ");
        doublyLL.reverseLL();
        doublyLL.display();
    }
}
