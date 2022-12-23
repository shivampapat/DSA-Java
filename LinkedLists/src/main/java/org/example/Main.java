package org.example;

import org.example.singly.LinkedList;

import java.lang.annotation.Inherited;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            LinkedList singlyLL =  new LinkedList();

            singlyLL.addFirst(11);
            singlyLL.addFirst(21);
            singlyLL.addFirst(31);
            singlyLL.addFirst(41);
            singlyLL.addFirst(51);

            singlyLL.display();
            System.out.println(singlyLL.count());

            singlyLL.deleteFirst();
            singlyLL.display();

            singlyLL.addLast(61);
            singlyLL.display();

            singlyLL.deleteLast();
            singlyLL.display();

            singlyLL.addAtIndex(3,71);
            singlyLL.display();

            singlyLL.deleteAtIndex(4);
            singlyLL.display();

            singlyLL.reverseLL();
            singlyLL.display();

            singlyLL.reverseLL();
            singlyLL.display();
    }
}