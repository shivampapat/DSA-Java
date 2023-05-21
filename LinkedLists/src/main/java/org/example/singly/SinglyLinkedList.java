package org.example.singly;


public class SinglyLinkedList {
    Node head;
    int size;

    public SinglyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void addFirst(int data){

        Node newNode = new Node(data);

        // LinkedList is empty
        if(this.head == null){
            this.head = newNode;
            this.size++;
            return;
        }
        //LL is not empty
        newNode.next = head;
        head = newNode;

        this.size++;
        System.out.println("Added a new node: " + data );
    }

    public Node deleteFirst(){

        //LL is empty
        if(this.head ==null ){
            return null;
        }
        //Store the node to be deleted and return that
        Node delNode = this.head;
        this.head = this.head.next;
        delNode.next = null; // safe null

        System.out.println("Deleted  node: " + delNode.data );
        this.size--;
        return delNode;
    }

    public void display(){

        System.out.println("LinkedList is :");

        if(head == null)
            return;

        Node temp = head;  //Copy head in temp because we don't have to update head

        while(temp != null){
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }

        System.out.println();
    }


    public int count(){
        System.out.println("LinkedList count is:");
        return this.size;
    }

    public void addLast(int data){

        Node newNode = new Node(data);

        if(this.head == null){
            head = newNode;
        }
        else
        {
            Node temp = this.head;
            while(temp.next != null){      //go to last node
                temp = temp.next;
            }
            temp.next = newNode;
        }

        this.size++;
        System.out.println("Added a new node: " + data );
    }

    public Node deleteLast(){
        if(head == null){
            return null;
        }

        Node delNode = null;

        // Only 1 node present in LL
        if(head.next == null){
            delNode = head;
            head = null;
            this.size--;
            return delNode;
        }

        //More than 1 node present in LL
        Node temp = this.head;
        while(temp.next.next != null)    //Go to second last node
        {
            temp = temp.next;
        }
        delNode = temp.next;      //Store last node to be returned
        temp.next = null;
        delNode.next = null; // safe null

        System.out.println("Deleted  node: " + delNode.data );
        this.size--;
        return delNode;
    }

    public void addAtIndex(int index, int data){

        //Consider 1 based position of nodes so first node is at position 1

        if(index <=0 || index >(size+1))
            return;

        //Adding in first position
        if(index == 1){
            addFirst(data);
        }
        //Adding in last position
        else if(index == this.size+1){
            addLast(data);
        }
        else
        {
            Node newNode = new Node(data);
            Node temp = head;

            for(int i=1;i<(index-1);i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Add a new  node: " + data );
            this.size++;
        }

    }

    public Node deleteAtIndex(int index)
    {
        if(index <=0 || index > this.size)
            return null;

        //Delete first node
        if(index == 1)
            return deleteFirst();
        //Delete last node
        else if (index == size)
            return deleteLast();

        //Delete from any other position
        Node delNode = null;
        Node temp = head;
        for (int i = 1; i < (index-1); i++)
        {
            temp  = temp.next;
        }
        delNode = temp.next;

        temp.next = temp.next.next;

        delNode.next = null; // safely

        System.out.println("Deleted  node: " + delNode.data );
        this.size--;
        return delNode;

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