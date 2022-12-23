package org.example.doubly;

public class LinkedList {

    Node head;
    int size;

    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    public LinkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    public void addFirst(int data){

        Node node = new Node(data);
        if(this.size == 0)
        {
            this.head = node;
            return;
        }

        node.next = head;
        head.prev= node;
        head = node;
    }

    public Node deleteFirst(){
        if(head == null)
            return null;
        
    }

    public void display(){
        Node temp = head;
        while (temp != null)
        {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
}
