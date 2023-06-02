package org.example.linkedlist;

public class Node {
    private int data;
    public Node next;

    public Node(){
        this.data = -1;
        this.next = null;
    }

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public int getData(){
        return this.data;
    }
}
