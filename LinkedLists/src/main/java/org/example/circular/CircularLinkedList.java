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

        if(head.next == head){
            Node node = head;
            node.next = null;
            head = null;
            this.size--;
            return node;
        }

        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        Node node = head;
        temp.next = head.next;
        head = head.next;
        node.next = null;
        this.size--;
        return node;
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
        Node node = new Node(data);
        if(head == null){
            head = node;
            node.next = node;
            this.size++;
            return;
        }

        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        node.next = head;
        temp.next = node;
        this.size++;
    }

    public Node deleteLast(){
        if(head == null)
            return null;

        if(head.next == head){
            Node node = head;
            head = null;
            this.size--;
            return node;
        }

        Node temp = head;
        while(temp.next.next != head){
            temp = temp.next;
        }

        Node node = temp.next;
        temp.next = head;
        this.size--;
        return node;
    }

    public void addAtIndex(int index, int data){
        if(index <=0 || index > size+1){
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
