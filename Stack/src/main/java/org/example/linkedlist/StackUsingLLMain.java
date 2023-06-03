import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

public class StackUsingLLMain
{
    public static void main(String argp[])
    {
        StackUsingLL stack = new StackUsingLL();

        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        stack.push(55);

        stack.display();

        Node deletedNode = stack.pop();
        System.out.println("Popped element is:"+ deletedNode.data);

        stack.display();

        Node peekNode = stack.peek();
        System.out.println("Peek element : " + peekNode.data);

        stack.display();

        stack.push(909);

        stack.display();

    }
}

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

class StackUsingLL
{
    //Create top for stack
    Node top;

    //Constructor
    public StackUsingLL()
    {
        this.top = null;
    }

    //Push new element into the stack
    public void push(int data)
    {
        //Create node for new data to be pushed
        Node newNode = new Node();
        newNode.data = data;

        //Check if object was created successfully in heap
        if (newNode == null) {
            System.out.println("Error: Fail to create object. Heap is full");
            return;
        }

        //Check if stack is empty
        if (top == null) {
            this.top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    //Get the top element of stack by removing it
    public Node pop()
    {

        if (isEmpty()) {
            System.out.println("Error:No elements present in stack to pop");
            return null;
        }

        Node delNode = top;
        top = top.next;

        delNode.next = null;
        return delNode;
    }

    //Get the top element of stack without removing it
    public Node peek()
    {

        if(isEmpty())
        {
            System.out.println("Error:No elements present in stack to pop");
            return null;
        }

        return top;
    }

    public void display()
    {
        Node temp = top;
        while(temp != null)
        {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean isEmpty()
    {
        return (top == null);
    }
}