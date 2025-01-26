import java.util.*;
class swapnodesll{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
        Node(int data,Node next)
        {
            this.data=data;
            this.next=next;
        }
    }
    static Node insert(Node node,Node head)
    {
        if(head == null){
        return node;
        }
        Node temp=head;
        while(temp.next != null)
        {
            temp=temp.next;
        }
        temp.next=node;
        return head;
    }
    static void print(Node head)
    {
        Node temp=head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        Node head=null;
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++)
        {
            int data=in.nextInt();
            Node node=new Node(data);
            head=insert(node,head);
        }
        Node prev=null;
        Node curr=head;
        Node next=curr.next;
        while(curr != null && curr.next != null)
        {
            curr.next=next.next;
            next.next=curr;
            if(prev == null)
            head=next;
            if(prev!=null)
            prev.next=next;
            prev=curr;
            curr=prev.next;
            if(curr != null)
            next=curr.next;
        }
        print(head);
        in.close();
    }
}