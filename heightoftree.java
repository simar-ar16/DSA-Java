/* Write a code to find the height of the given binary tree */

public class heightoftree {
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

    static Node constructTree(int[] arr,int index)
    {
        if(index >= arr.length || arr[index] == -1)
        return null;

        Node node=new Node(arr[index]);
        node.left=constructTree(arr, 2*index +1);
        node.right=constructTree(arr, 2*index +2);

        return node;
    }

    static int calHeight(Node root)
    {
        if(root == null)
        return -1;

        int leftHeight=calHeight(root.left);
        int rightHeight=calHeight(root.right);

        return Math.max(leftHeight, rightHeight)+1;
    }

    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4, -1, -1, 5, -1, -1,-1,-1,-1,-1, 6, 7};
        Node root=constructTree(arr,0);
        int height=calHeight(root);
        System.out.println("Height of tree is: "+height);
    }
}
