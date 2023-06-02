package org.example.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Stack {
    public Node head;
    public int size;

    public Stack() {
        head = null;
        size = 0;
    }

    public void push(int data){                //addFirst method of LinekedList

        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            this.size++;
            return;
        }
        node.next = head;
        head = node;
        this.size++;
    }

    public Node pop(){       //deleteFirst method of LL

        if(this.head ==null ){
            return null;
        }
        Node node = this.head;
        this.head = this.head.next;
        this.size--;
        return node;
    }

    public int peek(){
        if(this.head ==null ){
            return Integer.MIN_VALUE;
        }
        return head.getData();
    }

    public void display(){

        if(head == null)
            return;

        Node temp = head;  //Copy head in temp because we don't have to update head

        List<Integer> stack = new ArrayList<>();
        while(temp != null){
            stack.add(temp.getData());
            temp = temp.next;
        }

        Collections.reverse(stack);
        stack.forEach(System.out::print);

        System.out.println();
    }

    public int size(){
        return this.size;
    }

}
