package com.example.linkedlist;

//Remove duplicate element from sorted Linked List
//first we will select a first node and second the next node and we will check one by one if they are equal we will assign that first.next to  secon.next
public class question6 {
    public Node removeDuplicate(Node head){
        Node first = head;
        Node second = head.next;
        while (second!=null){
            if (first.value==second.value){
               second = second.next;
               first.next = second;
            }
            else {
                first = first.next;
                second = second.next;
            }
        }
        return head;
    }
}
