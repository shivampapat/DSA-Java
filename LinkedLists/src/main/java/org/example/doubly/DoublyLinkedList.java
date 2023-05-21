package org.example.doubly;

public class DoublyLinkedList {

    Node head;
    int size;

    public DoublyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public DoublyLinkedList(Node head) {
        this.head = head;
        this.size = 0;
    }

    public void addFirst(int data)
    {
        //Create node for the input data
        Node newNode = new Node(data);

        //Empty linked list
        if(head == null)
        {
            this.head = newNode;
            this.size++;
            return;
        }

        //More than 1 node present in LL
        Node temp = head;
        head = newNode;
        newNode.next = temp;
        temp.prev = newNode;

        this.size++;
    }

    public Node deleteFirst()
    {
        //Empty LL
        if(head == null)
            return null;

        //Create temporary node to store the node that is to be deleted
        Node delNode = null;

        //Only 1 node present in LL
        if(head.next == null)
        {
            delNode = head;
            head = null;
            this.size--;
            return delNode;
        }

        //More than 1 node present in LL
        delNode = head;
        head = head.next;
        head.prev = null;
        delNode.prev = delNode.next = null;  //Make null for safety reasons
        this.size--;

        return delNode;
    }

    public void display()
    {
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

        //Goto last node and then come back reverse using "prev"
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

    public void addLast(int data)
    {
        Node newNode = new Node(data);

        //Empty LL
        if(head == null){
            this.head = newNode;
            this.size++;
            return;
        }

        //More than 1 node present in LL
        Node temp = head;
        while(temp.next != null){    //Goto last node and then append the node at last
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
        this.size++;
    }

    public Node deleteLast()
    {
        Node delNode;
        //Empty LL
        if(head == null)
            return null;

        //Only 1 node present
        if(head.next == null){
            delNode = head;
            head = null;
            this.size--;
            return delNode;
        }

        //More than 1 node present in LL
        Node temp = head;
        while(temp.next.next != null){ // Goto second last node
            temp = temp.next;
        }
        delNode = temp.next;     //Store last node to be deleted
        temp.next = null;          //Make last node's next to null
        delNode.prev = delNode.next = null;   //Safe update to null
        this.size--;
        return delNode;
    }

    public void addAtIndex(int index, int data)
    {
        if(index <= 0 || index >size+1)
            return;
        if(index == 1){
            addFirst(data);
            return;
        }
        if(index == size+1){
            addLast(data);
            return;
        }

        //Goto 1 node previous to the position
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
        if(index <= 0 || index >size+1)
            return null;
        if(index == 1){
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
