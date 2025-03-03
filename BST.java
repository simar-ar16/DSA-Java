/*BST implementation */

import java.util.Scanner;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

        static Node insert(Node root,Node node)
        {
            if(root == null)
            return node;
            
            if(root.data > node.data)
            {
                root.left=insert(root.left,node);
            }
            if(root.data < node.data)
            {
                root.right=insert(root.right,node);
            }
            return root;
        }

        static void printinorder(Node root)
        {
            if(root == null)
            return;

            printinorder(root.left);
            System.out.print(root.data+" ");
            printinorder(root.right);
        }

        public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            int n=in.nextInt();
            Node root= null;
            for(int i=0;i<n;i++)
            {
                int item=in.nextInt();
                Node node=new Node(item);
                root=insert(root,node);
            }
            printinorder(root);
            in.close();
        }
}
