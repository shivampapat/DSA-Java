package org.example.circular;

import org.example.doubly.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.addFirst(11);
        circularLinkedList.addFirst(21);
        circularLinkedList.addFirst(31);
        circularLinkedList.addFirst(41);
        circularLinkedList.addFirst(51);

        System.out.println("\nDoubly LinkedList: ");
        circularLinkedList.display();
//        System.out.println("\nReversed LinkedList Display: ");
//        doublyLL.reverseDisplay();

        System.out.println("\nCount: ");
        System.out.println(circularLinkedList.count());

        System.out.println("\nDeleting first: ");
        circularLinkedList.deleteFirst();
        circularLinkedList.display();

        System.out.println("\nAdding Last: ");
        circularLinkedList.addLast(61);
        circularLinkedList.display();

        System.out.println("\nDeleting last: ");
        circularLinkedList.deleteLast();
        circularLinkedList.display();

        System.out.println("\nAdding at index 3: ");
        circularLinkedList.addAtIndex(3,71);
        circularLinkedList.display();

        System.out.println("\nDeleting at index 4: ");
        circularLinkedList.deleteAtIndex(4);
        circularLinkedList.display();

        System.out.println("\nCount: ");
        System.out.println(circularLinkedList.count());

        System.out.println("\nReversing Linked List: ");
        circularLinkedList.reverseLL();
        circularLinkedList.display();

        System.out.println("\nReversing Linked List: ");
        circularLinkedList.reverseLL();
        circularLinkedList.display();
    }
}
