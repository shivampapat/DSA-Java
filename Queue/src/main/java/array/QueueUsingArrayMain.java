package array;

public class QueueUsingArrayMain
{
    public static void main(String arg[])
    {
        QueueUsingArray queue = new QueueUsingArray(5);

        queue.enqueue(11);
        queue.enqueue(22);
        queue.enqueue(33);

        queue.display();

        System.out.println("Dequeue from queue");
        queue.dequeue();

        System.out.println("Dequeue from queue");
        queue.dequeue();

        queue.display();

        System.out.println("Peek queue: " + queue.peek());
        queue.display();

        queue.enqueue(77);
        queue.display();
    }
}

class QueueUsingArray
{
    int arr[];
    int front;
    int rear;
    int queueSize;

    //Default Constructor
    public QueueUsingArray()
    {
        this.arr = null;
        this.front = this.rear = -1;
        this.queueSize = 0;
    }

    //Parameterized Constructor where you accept max size of queue
    public QueueUsingArray(int size)
    {
        arr = new int[size];
        this.front = this.rear = -1;
        this.queueSize = 0;
    }

    public void enqueue(int data)
    {
        if(isFull())
        {
            System.out.println("Error: Queue is full. Cannot insert more elements");
            return;
        }

        rear = (rear + 1)% arr.length;
        arr[rear] = data;

        //If the element is FIRST in queue
        if(front == -1)
        {
            front++;
        }

        this.queueSize++;
    }

    public int dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Error: Queue is empty. Cannot remove elements");
            return -1;
        }

        int deletedElement = arr[front];
        front++;

        this.queueSize--;

        //If queue is empty after removing last element then reset FRONT and REAR pointers
        if(isEmpty())
        {
            rear = -1;
            front = -1;
        }

        return deletedElement;
    }

    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("Error: Queue is empty. Cannot remove elements");
            return -1;
        }

        return arr[front];
    }

    public boolean isEmpty()
    {
        if(this.queueSize == 0)
            return true;
        return false;
    }

    public boolean isFull()
    {
        if(this.queueSize == this.arr.length)
            return true;
        return false;
    }

    public void display()
    {
        System.out.println("Queue is : ");

        if(isEmpty())
            return;
        for(int i=front; i<=rear; i++)
        {
            System.out.printf("%d " , arr[i]);
        }

        System.out.println();
    }
}