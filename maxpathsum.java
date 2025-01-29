 /* Write a program to find the maximum sum of any path in a tree */
public class maxpathsum {
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

    static int maxSum(Node root)
    {
        if(root == null)
        return 0;

        int suml=root.data + maxSum(root.left);
        int sumr=root.data + maxSum(root.right);

        return Math.max(suml,sumr);
    }

    public static void main(String[] args) {
        int[] arr={5,1,2,-1,8,3,-1,-1,-1,-1,-1,-1,5};
        Node root=constructTree(arr,0);
        int sum=maxSum(root);
        System.out.println(sum);
    }
}
