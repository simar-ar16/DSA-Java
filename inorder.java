/* There is a binary tree with some integer values. Find the inorder traversal of tree */
public class inorder {
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
        node.left=constructTree(arr, 2*index+1);
        node.right=constructTree(arr, 2*index+2);

        return node;
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
        int[] arr={2,3,1,7,9,6,5};
        Node root=constructTree(arr,0);
        printinorder(root);
    }
}
