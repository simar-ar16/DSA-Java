/*We are given with a linked list and our task is 
 to simply reverse the linked list using recursion and print the reversed list */

 import java.util.Scanner;

 public class reverselistrecur {
     static class Node{
         int data;
         Node next;
         Node(int data)
         {
             this.data=data;
             this.next=null;
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
     static Node reverse(Node head)
     {
        if(head == null || head.next==null)
        return head;

        Node temp=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return temp;
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
         
        head=reverse(head);
        print(head);
        in.close();
     }
 }
 