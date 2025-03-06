/*Given a tree with int data,Node left,Node right and Node next. Populate next pointer to its right node. Leetcode 116*/

import java.util.LinkedList;
import java.util.Queue;

class populatenextpointer{
    static class Node{
        int data;
        Node left;
        Node right;
        Node next;
        Node(int data)
        {
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
        node.left=constructTree(arr, (2*index+1));
        node.right=constructTree(arr, (2*index+2));

        return node;
    }

    static Node populate(Node root)
    {
        if(root == null)
        return root;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        Node node=root;
        while(q.size() > 0)
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                node=q.remove();
                if(q.size() > 0)
                node.next=q.peek();
                if(node.left != null)
                q.add(node.left);
                if(node.right != null)
                q.add(node.right);
            }
            node.next=null;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        Node root=constructTree(arr,0);
        root=populate(root);

        System.out.println(root.left.next.data);
    }
}