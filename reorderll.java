/* Write a program to reorder linked list ie convert ll
 from A1->A2->A3->A4 ... -> A(n-1) ->A(n) 
 to   A(1)->A(n)->A2->A(n-1)....*/

 import java.util.*;
class reorderll
{
    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next=null;
        }
        Node(int data,Node next)
        {
            this.data=data;
            this.next=next;
        }
    }

    static Node insert(Node newnode,Node head)
    {
        if(head == null)
        {
            return newnode;
        }
        Node temp=head;
        while(temp.next != null)
        {
            temp=temp.next;
        }
        temp.next=newnode;
        return head;
    }

    static Node findmid(Node head)
    {
        if(head == null)
        return null;
        if(head.next == null)
        return head;
        Node slow=head;
        Node fast=head;
        while(fast.next != null && fast.next.next != null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    static Node reverse(Node mid)
    {
        if(mid.next == null)
        return mid;
        Node prev=null;
        Node curr=mid.next;
        Node next=curr.next;
        while(curr != null)
        {
            curr.next=prev;
            prev=curr;
            curr=next;
            if(curr != null)
            next=curr.next;
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

    public static void main(String Args[])
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Node head=null;
        for(int i=0;i<n;i++)
        {
            int data=in.nextInt();
            Node newnode=new Node(data);
            head=insert(newnode,head);
        }
        print(head);
        Node mid=findmid(head);
        Node rev=reverse(mid);
        Node temp=head;
        while(temp != null && rev != null)
        {
            Node flag=temp.next;
            temp.next=rev;
            temp=flag;

            flag=rev.next;
            rev.next=temp;
            rev=flag;
        }
        if(temp != null)
        {
            temp.next=null;
        }
        print(head);
    }
}