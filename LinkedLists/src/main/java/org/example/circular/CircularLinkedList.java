package org.example.circular;

public class CircularLinkedList {
    Node head;
    int size;

    public CircularLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void addFirst(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            node.next = node;
            this.size++;
            return;
        }

        Node temp = head;
        while(temp.next != head){ //Goto last node
            temp = temp.next;
        }
        node.next = head;
        head = node;
        temp.next = head; //Update last node
        this.size++;
    }

    public Node deleteFirst(){
        if(head == null)
            return null;

         //Only 1 node present in LL
        if(head.next == head){
            Node delNode = head;
            delNode.next = null;
            head = null;
            this.size--;
            return delNode;
        }

        Node temp = head;
        while(temp.next != head){    //Goto last node
            temp = temp.next;
        }
        Node delNode = head;
        temp.next = head.next;
        head = head.next;
        delNode.next = null;
        this.size--;
        return delNode;
    }

    public void display(){
        if(head == null)
            return;
        Node temp = head;
        while (temp.next != head) {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.printf("%d",temp.data); //Last node
    }

    public int count(){
        return this.size;
    }

    public void addLast(int data){
        Node newNode = new Node(data);

        //Empty LL
        if(head == null){
            head = newNode;
            newNode.next = newNode;
            this.size++;
            return;
        }

        //1 or more nodes present in LL
        Node temp = head;
        while(temp.next != head){  //Goto last node
            temp = temp.next;
        }
        newNode.next = head;
        temp.next = newNode;
        this.size++;
    }

    public Node deleteLast(){
        if(head == null)
            return null;

        //Only 1 node present
        if(head.next == head){
            Node delNode = head;
            head = null;
            this.size--;
            return delNode;
        }

        Node temp = head;
        while(temp.next.next != head){ //Goto second last node
            temp = temp.next;
        }

        //Store last node
        Node delNode = temp.next;
        temp.next = head;
        this.size--;
        return delNode;
    }

    public void addAtIndex(int index, int data){
        if(index <=0 || index > size+1){
            return;
        }

        if(this.head == null && index > 1){   //No node present but trying to add Node in LL at any place greater than 1
            return;
        }

        if(index == 1){
            addFirst(data);
        }
        else if(index == (size+1)){
            addLast(data);
        }
        else{
            Node temp = head;
            for(int i=2;i<index;i++){
                temp  = temp.next;
            }
            Node node = new Node(data);
            node.next = temp.next;
            temp.next = node;
            this.size++;
        }
    }

    public Node deleteAtIndex(int index){
        if(index <=0 || index > size+1){
            return null;
        }

        if(index == 1){
            return deleteFirst();
        }
        else if(index == (size+1)){
            return deleteLast();
        }
        else{
            Node temp = head;
            for(int i=2;i<index;i++){
                temp  = temp.next;
            }
            Node node = temp.next;
            temp.next = temp.next.next;
            this.size--;
            return node;
        }
    }

    public Node reverseLL(){
        if(head == null || head.next == head)
            return head;

        Node currNode = head;
        Node prevNode= null;
        Node nextNode = currNode.next;
        while (nextNode != head){
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.next;
        }
        currNode.next = prevNode;
        head.next = currNode;
        head = currNode;
        return head;
    }
}
