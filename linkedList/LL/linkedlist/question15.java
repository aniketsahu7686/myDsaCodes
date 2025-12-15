package com.example.linkedlist;

//find the middle element of the linkedlist

public class question15 {
    public static Node findMiddleElement(Node head){
        if (head==null || head.next==null){
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return head;
    }

}
