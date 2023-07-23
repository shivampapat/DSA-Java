import java.util.*;

public class AdjList
{
    public static void main(String arg[])
    {
        GraphUsingAdjList graph2 = new GraphUsingAdjList(4);
        graph2.addEdge(0,1);
        graph2.addEdge(0,2);
        graph2.addEdge(2,3);
        graph2.addEdge(1,2);

        System.out.println(graph2.isDirectConnected(0,2)); //true
        System.out.println(graph2.isDirectConnected(0,3)); //false
        System.out.println(graph2.isDirectConnected(1,2)); //true
        System.out.println(graph2.isDirectConnected(5,2)); // ??

        graph2.display();
        graph2.bfs(0);
        graph2.bfs(1);
        graph2.bfs(3);
    }
}


class GraphUsingAdjList
{
    List<Integer> arr[];

    public GraphUsingAdjList()
    {
        arr = null;
    }

    public GraphUsingAdjList(int size)
    {
        arr = new ArrayList[size];
        for(int i=0;i<arr.length; i++)
        {
            arr[i] = new ArrayList<Integer>();
        }
    }

    public void display()
    {
        
        for(int i=0;i< arr.length; i++)
        {
            System.out.printf("%d  --> " , i);
            System.out.println(arr[i]);
        }
    }
                             
    public void addEdge(int src, int dest)
    {
        if(src <0 || dest < 0 || src >= arr.length || dest >= arr.length)
            return;
        
        //Undirected
        arr[src].add(dest);
        arr[dest].add(src);
    }

    public boolean isDirectConnected(int src, int dest)
    {
        //TO-DO
        return false;
    }

    public void bfs(int root)
    {
        if(root <0 || root >= arr.length)
            return;
        
        boolean visited[] = new boolean[arr.length];

        for(int i=0;i<visited.length;i++)
            visited[i] = false;

        Queue<Integer> q = new LinkedList<Integer>(); //1

        q.add(root); //2

        while(!q.isEmpty())   //3
        {
            int current = q.poll();  //4
            System.out.printf("%d " , current); //5
            visited[current] = true; //6

            for(int i=0;i<arr[current].size();i++) //7
            {
                int temp = arr[current].get(i);

                if(!visited[temp] && !q.contains(temp))
                {
                    q.add(arr[current].get(i));
                }
            }
        }

        System.out.println();
    }

}