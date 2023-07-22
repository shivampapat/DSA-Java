import java.util.*;

public class AdjMatrix
{
    public static void main(String arg[])
    {
        GraphUsingAdjMatrix graph1 = new GraphUsingAdjMatrix(4);
        graph1.addEdge(0,1);
        graph1.addEdge(0,2);
        graph1.addEdge(2,3);
        graph1.addEdge(1,2);

        System.out.println(graph1.isDirectConnected(0,2)); //true
        System.out.println(graph1.isDirectConnected(0,3)); //false
        System.out.println(graph1.isDirectConnected(1,2)); //true
        System.out.println(graph1.isDirectConnected(5,2)); // ??

        graph1.display();
        
    }
}


class GraphUsingAdjMatrix
{
    public int arr[][];

    public GraphUsingAdjMatrix()
    {
        arr = null;
    }

    public GraphUsingAdjMatrix(int size)
    {
        arr = new int[size][];

        for(int i=0; i<size;i++)
        {
            arr[i] = new int[size];
        }
    }

    public void display()
    {
        for(int i=0;i < arr.length;i++)
        {
            for(int j=0; j<arr[i].length; j++)
            {
                System.out.printf("%d ", arr[i][j]);
            }

            System.out.println();
        }
    }


    public void addEdge(int src, int dest)
    {
        if(src < 0 || dest < 0 || src >= arr.length || dest >= arr.length)
            return;

        //Consider un-directed graph
        arr[src][dest] = 1;
        arr[dest][src] = 1;
    }

    public boolean isDirectConnected(int src, int dest)
    {

    }
}