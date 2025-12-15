package cdcCourse;

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
    static Node head;
    
    static class Node
    {
        Node next;
        int data;
        Node(int data)
        {
            this.data=data;
            this.next=null;
        }

    }
    public static void add(int d)
    {
        Node NN=new Node(d);
        if(head==null)
        {
            head=NN;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=NN;
    }
    Node reverse(Node h)
    {
        Node temp=h;
        Node prev=null;
        Node next=null;
        while(temp!=null)
        {
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
    Node middle(Node h)
    {
        Node hare=h;
        Node tortoise=h;
        while(hare!=null && hare.next!=null)
        {
            tortoise=tortoise.next;
            hare=hare.next.next;
        }
        return tortoise;
    }
    void rearrange(Node h)
    {
        Node mid=middle(h);
        Node rev=reverse(mid.next);
        mid.next=null;
        Node c1=h;
        Node c2=rev;
        Node f1=null;
        Node f2=null;
        while(c1!=null && c2!=null)
        {
            f1=c1.next;
            c1.next=c2;
            f2=c2.next;
            c2.next=f1;
            c1=f1;
            c2=f2;

        }
    }
    public static void printList()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Main m=new Main();
		Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String a[]=s.split("\\s+");
	
        for(int i=0;i<a.length;i++)
        {
            m.add(Integer.parseInt(a[i]));
        }
        m.rearrange(m.head);
        m.printList();
	}
}
