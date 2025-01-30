/* There is a binary tree with some integer values. Find the mirror(invert) of a tree and print the 
inorder traversal of the tree */
class mirrortree {
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

    static Node invert(Node root)
    {
        if(root == null)
        return null;

        invert(root.left);
        invert(root.right);
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;

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
        int[] arr={2,1,3,5,6,9,7};
        Node root=constructTree(arr,0);
        root=invert(root);
        printinorder(root);
    }
}
