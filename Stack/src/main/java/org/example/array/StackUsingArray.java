package org.example.array;

public class StackUsingArray
{
    public static void main(String args[])
    {
        StackArray s1 = new StackArray(6);
        s1.push(11);
        s1.push(22);
        s1.push(33);
        s1.push(44);
        s1.display();

        System.out.println("Element popped:" + s1.pop());

        s1.display();

        System.out.println("Element peeked:" + s1.peek());

        s1.display();

        s1.push(55);
        s1.display();
    }
}

class StackArray
{
    public int[] arr;  //Array declaration
    public int top;

    public StackArray()
    {
        arr = null;
        top = -1;
    }

    public StackArray(int size)
    {
        arr = new int[size]; //Array initialisation
        top = -1;  //Initial value
    }

    public boolean isFull()
    {
        if(top == (arr.length-1))
        {
            return true;
        }
        return false;
    }

    public boolean isEmpty()
    {
        if(top == -1)
        {
            return true;
        }
        return false;
    }

    public void push(int data)
    {
        if(isFull())
        {
            System.out.println("Error:Stack is full Cannot add more elements");
            return;
        }
        System.out.println("Pushing element in stack");
        top++;
        arr[top] = data;
    }

    public int pop()
    {
        if(isEmpty())
        {
            System.out.println("Error: Stack is empty. Cannot remove any more elements");
            return -1;
        }

        int data = arr[top];
        top--;
        return data;
    }

    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("Error: Stack is empty. Cannot remove any more elements");
            return -1;
        }

        return arr[top];
    }

    public void display()
    {
        System.out.println("Stack is : ");

        for(int i=0; i<= top; i++)
        {
            System.out.printf("%d ", arr[i]);
        }

        System.out.println();
    }
}
