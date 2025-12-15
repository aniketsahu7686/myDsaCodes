package cdcCourse;

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

class Main {
    Node head = null;
    int size = 0;

    void add(int data) {   
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = n; 
        }
        size++;
    }
     
    Node segg(Node h) {
        Node current = h;
        Node eh = null;
        Node et = null;
        Node oh = null;
        Node ot = null;
        
        while (current != null) {
            if (current.data % 2 == 0) {
                if (eh == null) {
                    eh = current;
                    et = current;
                } else {
                    et.next = current;
                    et = et.next;
                }
            } else {
                if (oh == null) {
                    oh = current;
                    ot = current;
                } else {
                    ot.next = current;
                    ot = ot.next;
                }
            }
            current = current.next;
        }
        
        if (eh == null) {
            eh = oh;
        } else {
            et.next = oh;
        }
        if (ot != null) {
            ot.next = null;
        }
        
        return eh;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Main m = new Main();
        Scanner sc = new Scanner(System.in); 
        // next line is a method, which is present in a scanner class which is used when we have to 
        // input the string with spaces
        String s = sc.nextLine();
        String sarr[] = s.split("\\s+");  //{"1","2"}
        for (int i = 0; i < sarr.length; i++) {
            m.add(Integer.parseInt(sarr[i]));
        }
        Node newH = m.segg(m.head);
        while (newH != null) {
            System.out.print(newH.data + " ");
            newH = newH.next;
        }  
    }
}
