//Construct a tree from given array and print the level order traversal of tree
import java.util.*;

public class levelordertraverse {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static Node constructTree(int[] arr,int index)
    {
        if(index >= arr.length || arr[index] == -1)
        return null;

        Node node=new Node(arr[index]);
        node.left=constructTree(arr, (2*index)+1);
        node.right=constructTree(arr, (2*index)+2);

        return node;
    }

    static void printLevelOrder(Node root)
    {
        if(root == null)
        return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int count=q.size();
            for(int i=0;i<count;i++)
            {
                Node temp=q.remove();
                if(temp.left != null)
                {
                    q.add(temp.left);
                }
                if(temp.right != null)
                {
                    q.add(temp.right);
                }
                System.out.print(temp.data+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,-1,10,5,-1};
        Node root=constructTree(arr,0);
        printLevelOrder(root);
    }
}
