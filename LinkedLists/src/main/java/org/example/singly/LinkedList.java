package org.example.singly;


public class LinkedList {
    Node head;
    int size;

    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void addFirst(int data){

        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            this.size++;
            return;
        }
        Node temp = this.head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        this.size++;
    }

    public Node deleteFirst(){       //0 means success and -1 means error

        if(this.head ==null ){
            return null;
        }
        Node node = this.head;
        this.head = this.head.next;
        this.size--;
        return node;
    }

    public void display(){
        Node temp = head;  //Copy head in temp because we don't have to update head

        while(temp != null){
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    //
    public int count(){
        return this.size;
    }

    public void addLast(int data){
        if(this.head == null){
            return;
        }
        Node node = new Node(data);
        Node temp = this.head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        this.size++;
    }

    public Node deleteLast(){
        if(head == null){
            return null;
        }

        Node node = null;
        if(head.next == null){
            node = head;
            head = null;
            return node;
        }

        Node temp = this.head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = node;
        temp.next = null;
        this.size--;
        return node;
    }

    public void addAtIndex(int index, int data){

        if(index <=0 || index >(size+2))
            return;

        if(this.head == null && index > 1){
                return;
        }
        if(index == 1){
            addFirst(data);
        }
        else if(index == this.size+1){
            addLast(data);
        }
        else{
            Node node = new Node(data);
            Node temp = head;
            for(int i=2;i<index;i++){
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
        this.size++;
    }

    public Node deleteAtIndex(int index){
        if(index <=0 || index >size)
            return null;

        if(head == null)
            return null;

        if(index == 1)
            return deleteFirst();
        else if (index == size)
            return deleteLast();
        else{
            Node node = null;
            Node temp = head;
            for (int i = 2; i < index; i++) {
                temp  = temp.next;
            }
            temp.next = temp.next.next;
            return node;
        }
    }

    public void reverseLL(){
        if(this.size <2)
            return;

        if(this.size == 2){
            head.next.next = head;
            head = head.next;
            head.next.next = null;
        }
        Node currNode = head;
        Node prevNode = null;
        Node nextNode = head.next;

        while(nextNode != null){
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            nextNode = currNode.next;
        }
        currNode.next = prevNode;
        head = currNode;

    }
}