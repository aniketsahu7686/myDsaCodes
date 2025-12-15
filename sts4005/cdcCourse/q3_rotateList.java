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

  
    Node rotate(Node head,int k){
        Node tail = head;
        for(int i=0;i<size-k-1;i++){
            tail = tail.next;
        }
        Node newHead = tail.next;
        tail.next = null;
        Node temp = newHead;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
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
       int x = sc.nextInt();
    //    int k =sc.nextInt();
       Node newHead = m.rotate(m.head,2);
       while(newHead!=null){
           System.out.print(newHead.data + " ");
           newHead = newHead.next;
       }
	}
}
