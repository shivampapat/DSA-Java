package org.example.doubly;

public class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(){
        this.data = 0;
        this.next = this.prev = null;
    }

    public Node(int data){
        this.data = data;
        this.next = this.prev = null;
    }
}
