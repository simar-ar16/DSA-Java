import java.util.Scanner;

public class mergeksortedlists {
    static class Node{
        int data;
        Node next;
        Node()
        {

        }
        Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }

    static Node insert(Node node,Node head)
    {
        if(head == null)
        return node;
        Node temp=head;
        while(temp.next != null)
        {
            temp=temp.next;
        }
        temp.next=node;
        return head;
    }

    static Node combine(Node[] arr)
    {
        if(arr.length == 1)
        return arr[0];

        Node first=arr[0];
        Node res=null;
        for(int i=1;i<arr.length;i++)
        {
            res=merge(first,arr[i]);
            first=res;
        }
        return res;
    }

    static Node merge(Node list1,Node list2)
    {
        Node res=new Node();
        Node tail=res;
        while(list1 != null && list2 != null)
        {
            if(list1.data < list2.data)
            {
                tail.next=list1;
                tail=tail.next;
                list1=list1.next;
            }
            else{
                tail.next=list2;
                tail=tail.next;
                list2=list2.next;
            }
        }
        tail.next = list1 == null ? list2 :list1;
        return res.next;
    }

    static void print(Node head)
    {
        Node temp=head;
        while(temp != null)
        {
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Number of lists:");
        int k=in.nextInt();
        Node[] arr=new Node[k];
        for(int i=0;i<k;i++)
        {
            System.out.println("Number of elements in List "+(i+1));
            int n=in.nextInt();
            Node head=null;
            arr[i]=head;
            System.out.println("Enter elements in list "+(i+1));
            for(int j=0;j<n;j++)
            {
                int item=in.nextInt();
                Node node=new Node(item);
                head=insert(node,head);
            }
            arr[i]=head;
        }
       
        Node res=combine(arr);
        print(res);
        in.close();
    }
}
