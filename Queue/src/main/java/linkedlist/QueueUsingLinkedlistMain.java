package linkedlist;


public class QueueUsingLinkedlistMain
{
    public static void main(String argp[])
    {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();

        //Add nodes
        queue.enqueue(11);
        queue.enqueue(21);
        queue.enqueue(31);

        queue.display();

        //Remove nodes
        queue.dequeue();
        queue.dequeue();

        queue.display();

        //Peek front node (it does not remove node from queue)
        System.out.println("Peek: " + queue.peek().data);
        queue.display();

        //Remove 1 more node
        queue.dequeue();
        queue.display();                    //Now Queue is empty

        //Add few more nodes
        queue.enqueue(41);
        queue.enqueue(51);

        queue.display();
    }
}

//Node class is same as of Singly Linked List
class Node
{
    int data;
    Node next;

    public Node()
    {
        this.data = 0;
        this.next = null;
    }
}

class QueueUsingLinkedList
{
    Node front;
    Node rear;

    //Default constructor,  here no need for getting size as linked list is not fixed size.
    public QueueUsingLinkedList()
    {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int data)
    {
        //1
        Node newNode = new Node();
        newNode.data = data;

        //Check if object got created or failed
        if(newNode == null)
        {
            System.out.println("Error: Fail to create object. Heap is full");
            return;
        }

        if(isEmpty())     //This means rear is also null  meaning queue is empty
        {
            this.front = newNode;
            this.rear = newNode;
        }
        else                 //Add it from last side (Same as add node to last in linked list)
        {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Node dequeue()
    {

        if(isEmpty())
        {
            System.out.println("Error:No elements present in stack to pop");
            return null;
        }

        //Remove it from front
        Node delNode = front;  //Store the node to be removed

        if(front == rear)   //Only 1 element is left
        {
            front = rear = null;
        }
        else{
            front = front.next;
        }

        delNode.next = null;    //Safe null
        return delNode;           // return the removed node
    }

    public Node peek()
    {

        if(isEmpty())
        {
            System.out.println("Error:No elements present in stack to pop");
            return null;
        }

        return front;
    }

    public void display()
    {
        if(isEmpty())
        {
            System.out.println("Queue is EMpty");
            return;
        }
        Node temp = front;
        while(temp != null)
        {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean isEmpty()
    {
        return (front == null && rear == null);
    }
}