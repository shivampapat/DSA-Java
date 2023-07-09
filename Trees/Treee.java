public class Treee
{
  public static void main(String arg[])
  {
        Tree t = new Tree();
        t.insertIntoTree(10);
        t.insertIntoTree(0);
        t.insertIntoTree(13);
        t.insertIntoTree(11);
        t.insertIntoTree(1);
        t.insertIntoTree(6);
        t.insertIntoTree(17);
        t.insertIntoTree(19);
        
        t.display(t.root);
        System.out.println();

        Node res = t.search(t.root,6);
        if(res != null)
            System.out.println(res.data);

        res = t.search(t.root,11);
        if(res != null)
            System.out.println(res.data);
  }
}

class Node 
{
 int data;
 Node left;
 Node right;
 
 public Node(int data)
 {
      this.data = data;
      left = right = null;
 }
 
 public Node()
 {
      this.data = 0;
      left = right = null;
 }
}

class Tree{

      Node root;
      public Tree()
      {
           root= null;
      }
      
      public void insertIntoTree(int data)
      {
           Node temp = root;
           Node newNode = new Node(data);
           
           if (temp==null)
           {
               root = newNode;
               return;
           }
          
           while(temp != null)
           {
                 if(data < temp.data)
                 {
                     if(temp.left != null)
                     {
                        temp = temp.left;
                     }
                     else
                     {
                         temp.left= newNode;
                         break;
                     }
                 }
                 else{
                     if(temp.right != null)
                     {
                        temp = temp.right;
                     }
                     else
                     {
                         temp.right = newNode;
                         break;
                     }
                 }
                
           }
      }
      
      public void display(Node root)
      {
            if(root == null)
                return;
            //pre-order traversal
            System.out.printf("%d " , root.data);
            display(root.left);
            display(root.right);
      }

      public Node search(Node root, int data)
      {
        if(root == null)
            return null;

        if(data == root.data)
        {
            return root;
        } 
        else if(data >root.data)
        {
            return search(root.right, data);
        }
        return search(root.left, data);
      }
}


//in -> left root right
//post -> left right root