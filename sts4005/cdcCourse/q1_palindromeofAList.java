package cdcCourse;

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data; 
            next = null;
        }
}    
class Main
{
    Node head = null;
    int size = 0;
     void add(int data){   
        Node n = new Node(data);
        if(head == null){
            head = n;
        }else{
            Node current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = n; 
        }
        size++;

    }
     boolean palindromeList(Node head){
        int mid = (size%2==0) ? size/2 : (size+1)/2;
        Node current = head;
        for(int i=1;i<mid;i++){
            current = current.next;
        }
        Node revHead = reverse(current.next);
        while(head!=null && revHead!=null){
            if(head.data != revHead.data){
                return false;
            }
            head = head.next;
            revHead = revHead.next;
        }
        return true;
    } 
    public  Node reverse(Node head){
        Node current = head;
        Node prev = null;
        Node next = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return  prev;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Main m = new Main();
        Scanner sc = new Scanner(System.in); 
        // next line is a method , which is present in a scanner class which is used when we have to 
        // input the string with spaces
        String s = sc.nextLine();
        String sarr[] = s.split("\\s+");  //{"1","2"}
        for(int i=0;i<sarr.length;i++){
            m.add(Integer.parseInt(sarr[i]));
        }

        boolean ans = m.palindromeList(m.head);
        System.out.println(ans);
	}
}
