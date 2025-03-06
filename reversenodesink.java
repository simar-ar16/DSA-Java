import java.util.Scanner;

public class reversenodesink {
    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }

    static Node insert(Node head,Node node)
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


    static Node result(Node head,int k)
    {
        Node curr=head;
        Node prev=null;
        Node next=null;
        int count=0;
        while(curr != null && count < k)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        if(next != null)
        {
            head.next=result(next, k);
        }
        return prev;
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
        int n=in.nextInt();
        Node head=null;
        for(int i=0;i<n;i++)
        {
            int item=in.nextInt();
            Node node=new Node(item);
            head=insert(head,node);
        }

        int k=in.nextInt();
        
        head=result(head,k);
        print(head);

        in.close();
    }
}
