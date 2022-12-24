package org.example.doubly;

public class DoublyLinkedList {

    Node head;
    int size;

    public DoublyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public DoublyLinkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    public void addFirst(int data){

        Node node = new Node(data);
        if(this.size == 0)
        {
            this.head = node;
            this.size++;
            return;
        }

        node.next = head;
        head.prev= node;
        head = node;
        this.size++;
    }

    public Node deleteFirst(){
        if(head == null)
            return null;

        Node node;
        if(head.next == null){
            node = head;
            head = null;
            this.size--;
            return node;
        }
        node = head;
        head = head.next;
        node.prev = node.next = null;
        head.prev = null;
        this.size--;
        return node;
    }

    public void display(){
        if(head == null)
            return;

        Node temp = head;
        while (temp != null)
        {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public void reverseDisplay(){
        if(head == null)
            return;
        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        while(temp != null){
            System.out.printf("%d ", temp.data);
            temp = temp.prev;
        }
    }

    public int count(){
        return this.size;
    }

    public void addLast(int data){
        Node node = new Node(data);
        if(head == null){
            addFirst(data);
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
        this.size++;
    }

    public Node deleteLast(){
        Node node;
        if(head == null)
            return null;

        if(head.next == null){
            node = head;
            head = null;
            this.size--;
            return node;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        node = temp;
        temp.prev.next = null;
        node.prev = node.next = null;
        this.size--;
        return node;
    }

    public void addAtIndex(int index, int data){
        if(index < 0 || index >size+1)
            return;
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size+1){
            addLast(data);
            return;
        }

        Node temp = head;
        for(int i=2;i<index;i++){
            temp = temp.next;
        }

        Node node = new Node(data);
        node.next = temp.next;
        node.prev = temp;
        temp.next = node;
        node.next.prev = node;
        this.size++;
    }

    public Node deleteAtIndex(int index){
        if(index < 0 || index >size+1)
            return null;
        if(index == 0){
            return deleteFirst();
        }
        if(index == size+1){
            return deleteLast();
        }

        Node temp = head;
        for(int i=2;i<index;i++){
            temp = temp.next;
        }

        Node node = temp.next;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        node.next = null;
        node.prev = null;
        this.size--;
        return node;
    }

    public void reverseLL(){
        if(head == null || head.next == null)
            return;

        Node currNode = head;
        Node nextNode = head.next;

        while(nextNode != null){
            currNode.next = currNode.prev;
            currNode.prev = nextNode;
            currNode = nextNode;
            nextNode = nextNode.next;
        }
        currNode.next =currNode.prev;
        currNode.prev = null;
        head = currNode;
    }
}
