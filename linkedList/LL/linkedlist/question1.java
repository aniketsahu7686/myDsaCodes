package com.example.linkedlist;

//reverse a linkedlist with using extra space so that our time complexity will be O(1) and time complexity will be O(N)

//What is difference between static and public in Java?
//public − This is the access specifier that states that the method can be accesses publically. static − Here, the object is not required to access static members. void −
//        This states that the method doesn't return any value.
public class question1 {
    public static Node reverseLinkedList(Node value){
        Node curr = value;
        Node prev = null;
        while (curr!=null){
            Node newNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newNext;
        }
        return prev;
    }

    public static void main(String[] args) {

    }

}
