package com.example.linkedlist;

public class question16 {
    public boolean isCirculatLinkedList(Node head){
        Node current = head;
        while (head!=null){
            if (current.next==head){
                return true;
            }
            current=current.next;
        }
        return false;
    }
}
